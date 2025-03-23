package com.cog.controller;

import com.cog.bean.StudentBean;
import com.cog.bean.UserBean;
import com.cog.dao.StudentRepository;
import com.cog.dao.UserRepository;
import com.cog.dom.Role;
import com.cog.dom.Student;
import com.cog.dom.User;
import com.cog.jwt.AuthRequestDTO;
import com.cog.jwt.JwtResponseDTO;
import com.cog.service.EmployeeService;
import com.cog.service.JwtService;
import com.cog.service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.WebSession;


import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private JwtService jwtService;
    private HttpSession session;
    private PasswordEncoder passwordEncoder;
    private StudentRepository studentRepository;


    private final EmployeeService service;
    private final StudentService studentService;

   // @Value("${welcome.message}")
   // private String welcomeMessage;



    @Autowired
    public LoginController(
            AuthenticationManager authenticationManager,
            UserRepository userRepository,
            StudentRepository studentRepository,
            JwtService jwtService,
            HttpSession session,
            PasswordEncoder passwordEncoder, EmployeeService service, StudentService studentService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.jwtService = jwtService;
        this.session = session;
        this.passwordEncoder=passwordEncoder;

        this.service = service;
        this.studentService = studentService;
    }

    @PostMapping(value = "/register" , consumes = "application/json")
   // @PreAuthorize("hasRole('USER')")
   // @PreAuthorize("hasAuthority('ROLE_USER')")
    @PreAuthorize("hasRole('USER')")
    //@PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<User> userRegister(@Validated @RequestBody UserBean userBean)  {
        LOGGER.isDebugEnabled();
        User user = new User();
        user.setUsername(userBean.getUsername());
        user.setPassword(passwordEncoder.encode(userBean.getPassword()));


        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @PostMapping(value="/login" , consumes = "application/json")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<JwtResponseDTO> loginUser(@RequestBody AuthRequestDTO authRequestDTO)  {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        if(authentication.isAuthenticated()){
            session.setAttribute("token" , jwtService.generateToken(authRequestDTO.getUsername()));
            return new ResponseEntity<>(JwtResponseDTO.builder()
                    .accessToken(session.getAttribute("token").toString()).build(), HttpStatus.CREATED);
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }

    }

    @GetMapping(value = "/api/students")
    public List<StudentBean> getAllStudents() {
        return studentService.getAllStudents().stream()
                .map(student -> new StudentBean(student.getId(), student.getUsername(),student.getCourse(),student.getEmail()))
                .toList(); // Java 16+ feature
    }

    @PostMapping(value = "/studentRegister" , consumes = "application/json")
   // @PreAuthorize("hasRole('USER')")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Student> studentRegisterForm(@Validated @RequestBody StudentBean studentBean)  {
        LOGGER.isDebugEnabled();
        Student student = new Student();
        student.setUsername(studentBean.getUsername());
        student.setCourse(studentBean.getCourse());
        student.setEmail(studentBean.getEmail());
        studentRepository.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
}
