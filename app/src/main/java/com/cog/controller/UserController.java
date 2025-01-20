package com.cog.controller;

import com.cog.bean.UserBean;
import com.cog.dao.impl.UserRepository;
import com.cog.dom.User;
import com.cog.jwt.AuthRequestDTO;
import com.cog.jwt.JwtResponseDTO;
import com.cog.jwt.JwtService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "MyController", description = "My Controller Description")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private JwtService jwtService;
    private HttpSession session;
    private PasswordEncoder passwordEncoder;


    @Value("${welcome.message}")
    private String welcomeMessage;

    @Autowired
    public UserController(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                          JwtService jwtService,
                          HttpSession session,
                          PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.session = session;
        this.passwordEncoder=passwordEncoder;
    }


    @PostMapping(value = "/register" , consumes = "application/json")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<User> userRegister(@Valid @RequestBody UserBean userBean)  {
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
            session.setAttribute("token" , jwtService.GenerateToken(authRequestDTO.getUsername()));
            return new ResponseEntity<>(JwtResponseDTO.builder()
                    .accessToken(session.getAttribute("token").toString()).build(), HttpStatus.CREATED);
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }

    }
}
