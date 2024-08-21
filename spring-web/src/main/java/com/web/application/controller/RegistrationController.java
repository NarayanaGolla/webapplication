package com.web.application.controller;


import com.web.application.dao.impl.UserRepository;
import com.web.application.dom.User;
import com.web.application.dom.UserInfo;
import com.web.application.dom.UserRole;
import com.web.application.dto.AuthRequestDTO;
import com.web.application.dto.JwtResponseDTO;
import com.web.application.exception.CustomException;
import com.web.application.jwt.JwtService;
import com.web.application.service.RegisterService;
import com.web.application.bean.RegisterBean;
import com.web.application.dom.Register;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


//@RestController
@Controller
@Tag(name = "MyController", description = "My Controller Description")
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationController {

    //  ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF.
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Value("${msg:Config Server is not working. Please check...}")
    private String msg;

    @Autowired
    private ServletContext context;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;


//    @GetMapping(value = "/")
//    public String redirect() {
//        logger.info("context path : {} " , context.getContextPath() );
//        return "redirect:index.html";
//    }

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     *
     * @param registerBean
     * @return
     * @throws CustomException
     */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Register.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content) })

    @PostMapping(value = "/register" , consumes = "application/json")
    @ResponseBody
    @Operation(summary = "Greet a person by name")
    public ResponseEntity<Register> userRegister(@Valid @RequestBody RegisterBean registerBean) throws CustomException {

        validateInput(registerBean);
        validateService();
        Register register = convertToRegister(registerBean);
        checkUserExistence(register);
        registerService.save(register);
        return new ResponseEntity<>(register, HttpStatus.CREATED);

    }

    /**
     *
     * @param authRequestDTO
     * @return
     * @throws CustomException
     */

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Register.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content) })
    @PostMapping("/login")
    @Operation(summary = "User logged in the application")
    public ResponseEntity<JwtResponseDTO> loginUser(@RequestBody AuthRequestDTO authRequestDTO) throws CustomException {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        if(authentication.isAuthenticated()){
            return new ResponseEntity<>(JwtResponseDTO.builder()
                    .accessToken(jwtService.GenerateToken(authRequestDTO.getUsername())).build(), HttpStatus.CREATED);

        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }

    }

    /**
     *
     * @param authRequestDTO
     * @return
     */

  //  @PostAuthorize("hasAuthority('USER')")
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping(value = "/authenticate" , consumes = "application/json")
    public ResponseEntity<JwtResponseDTO> AuthenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        if(authentication.isAuthenticated()){
            return new ResponseEntity<>(JwtResponseDTO.builder()
                    .accessToken(jwtService.GenerateToken(authRequestDTO.getUsername())).build(), HttpStatus.CREATED);
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }

    /**
     *
     * @return
     */

    //@PreAuthorize("hasAuthority('ADMIN')")
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/ping")
    public ResponseEntity<String>  test() {
        try {
            return new ResponseEntity<>("hello", HttpStatus.OK);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @return
     */

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/userRegisterList")
    public ResponseEntity<List<Register>>  readUserRegisterList() {
        try {
            List<Register> registerList = registerService.fetchUserRegisterList();
            return new ResponseEntity<>(registerList, HttpStatus.OK);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Convert Register domain object
     * @param registerBean
     * @return
     */

    private Register convertToRegister(RegisterBean registerBean) {

        Register register = new Register();
        addUserInfo(register , registerBean);
        addRegister(register , registerBean);

        return register;
    }

    /**
     *
     * @param register
     * @param registerBean
     */

    private void addRegister(Register register, RegisterBean registerBean) {

        register.setUserName(registerBean.getUserName());
        register.setPassword(registerBean.getPassword());
        register.setInActive(registerBean.isInActive());
        register.setEmailId(registerBean.getEmailId());
        register.setGender(registerBean.getGender());
        register.setPhoneNumber(registerBean.getPhoneNumber());
        register.setCountry(registerBean.getCountry());
        register.setCreateDate(registerBean.getCreateDate());
    }

    /**
     * Add UserInfo object to Register Domain
     * @param register
     * @param registerBean
     */
    private void addUserInfo(Register register ,RegisterBean registerBean ) {

        Set<UserRole> userRoleList = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setName("USER");

        UserRole userRole2 = new UserRole();
        userRole2.setName("ADMIN");

        userRoleList.add(userRole);
        userRoleList.add(userRole2);

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(registerBean.getUserName());
        userInfo.setPassword(registerBean.getPassword());
        userInfo.setRoles(userRoleList);

        register.setUserInfo(userInfo);
    }

    /**
     *  Validate user is already registered or not
     * @param register
     * @throws CustomException
     */
    private void checkUserExistence(Register register) throws CustomException {
        if (registerService.userExists(register.getUserName(), register.getEmailId())) {
            throw new RuntimeException("Username or email address already in use.");
        }
    }

    /**
     * Validate Register Bean should not be null
     * @param registerBean
     */
    private void validateInput(RegisterBean registerBean) {
        Assert.notNull(registerBean, "registerBean must not be null");
    }

    /**
     *  Validate registerService should not be null
     */
    private void validateService() {
        Assert.notNull(registerService, "registerService must not be null");
    }


}
