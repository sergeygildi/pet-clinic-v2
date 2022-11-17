package ua.hildi.petclinicv2.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
@Configuration
@Slf4j
public class LoggingAspectAnnotationDriven {

    @Before("execution(* ua.hildi.petclinicv2.controllers.GeneralController.handleException(..))")
    public void beforeExceptionHandler(JoinPoint jp) {
        log.info("(beforeExceptionHandler) Before executing '" + jp.getSignature().toLongString() + "'");
    }

    @After("execution(* ua.hildi.petclinicv2.controllers.GeneralController.handleException(..))")
    public void afterExceptionHandler(JoinPoint jp) {
        log.info("(afterExceptionHandler) Before executing '" + jp.getSignature().toLongString() + "'");
    }

    @Before("execution(* ua.hildi.petclinicv2.PetClinicV2Application.*(..))")
    public void beforeSampleWebUiApplication(JoinPoint jp) {
        log.info("(beforePetClinicV2Application) Before executing '" + jp.getSignature().toLongString() + "'");
    }

    @After("execution(* ua.hildi.petclinicv2.PetClinicV2Application.*(..))")
    public void afterSampleWebUiApplication(JoinPoint jp) {
        log.info("(afterPetClinicV2Application) After executing '" + jp.getSignature().toLongString() + "'");
    }

    @Before("execution(* ua.hildi.petclinicv2.controllers.*.*(*))")
    public void beforeAdviceWeb(JoinPoint jp) {
        log.info("(beforeAdviceWeb) Before executing '" +
                jp.getSignature().toLongString() + "'");
    }

    @After("execution(* ua.hildi.petclinicv2.controllers.*.*(*))")
    public void afterAdviceWeb(JoinPoint jp) {
        log.info("(afterAdviceWeb) After executing '" +
                jp.getSignature().toLongString() + "'");
    }
}
