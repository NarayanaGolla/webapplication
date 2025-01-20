//package com.cog.aop;
//
//
//import com.cog.bean.UserBean;
//
//import com.cog.jwt.AuthRequestDTO;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.jetbrains.annotations.NotNull;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class EmployeeServiceAspect {
//
//    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//
//   // @Before("customerLoginLogger()")
//   @Before(value = "execution(* com.web.application.controller.RegistrationController.loginUser(..)) && args(authRequestDTO)")
//   public void beforeAdvice(JoinPoint joinPoint , AuthRequestDTO authRequestDTO) {
//        System.out.println("Before method:" + joinPoint.getSignature());
//    }
//
//    @Before(value = "execution(* com.web.application.controller.RegistrationController.userRegister(..)) && args(registerBean)")
//   // @Before("selectAll()")
//    public void customerRegistration(@NotNull JoinPoint joinPoint , UserBean registerBean) {
//        System.out.println("Before method:" + joinPoint.getSignature());
//    }
//
////    @AfterReturning(value = "execution(* com.training.springboot.controller.UserRegistrationController.readFromReactJs(..)) ",
////                    returning = "result")
////    public void afterReturning(JoinPoint joinPoint, Object result) {
////        LOGGER.info("{} returned with value {}", joinPoint, result);
////    }
////
////    @Pointcut("execution(* com.training.springboot.controller.LoginController.customerLogin(..)) ")
////    private void customerLoginLogger(){}
////
////    @Pointcut("execution(* com.training.springboot.controller.LoginController.saveFromReactJs(..)) && args(registerBean)")
////    private void selectAll(){}
//}
