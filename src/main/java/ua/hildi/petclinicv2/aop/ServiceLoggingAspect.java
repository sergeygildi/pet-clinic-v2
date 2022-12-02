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
public class ServiceLoggingAspect {

    @Before("execution(* ua.hildi.petclinicv2.services.*.*(*))")
    public void beforeAdviceService(JoinPoint jp) {
        log.info("(beforeAdviceService) Before executing '" +
                jp.getSignature().toLongString() + "'");
    }

    @After("execution(* ua.hildi.petclinicv2.services.*.*(*))")
    public void afterAdviceService(JoinPoint jp) {
        log.info("(afterAdviceService) After executing '" +
                jp.getSignature().toLongString() + "'");
    }

}
