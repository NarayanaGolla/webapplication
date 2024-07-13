package com.web.application.controller;


import com.web.application.service.RegisterService;
import com.web.bean.RegisterBean;
import com.web.dom.Register;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;

@CrossOrigin(origins = "http://localhost:3000")
//@RestController
@Controller
@Tag(name = "MyController", description = "My Controller Description")
public class RegistrationController {

    //  ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF.
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Value("${msg:Config Server is not working. Please check...}")
    private String msg;

    @Autowired
    private ServletContext context;

    @Autowired
    private RegisterService registerService;

    @GetMapping(value = "/")
    public String redirect() {
        logger.info("context path : {} " , context.getContextPath() );
        return "redirect:index.html";
    }


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
    public ResponseEntity<Register> userRegister(@Valid @RequestBody RegisterBean registerBean) {
        Assert.notNull(registerBean, "registerBean must not be null");

        Serializable id = null;
        Register register = new Register();
        register.setUserName("Narayana");
        register.setPassword("sankar");
        register.setInActive(true);
        register.setEmailId("gollanarayana114@gmail.com");
        register.setGender("M");
        register.setPhoneNumber("9986275546");
        register.setCountry("IND");
        register.setCreateDate("06-06-1986");
        registerService.save(register);
        return new ResponseEntity<>(register, HttpStatus.CREATED);
    }


}
