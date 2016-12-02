package webservice.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class LoggerService {

    public final static Logger log = Logger.getLogger(LoggerService.class);

    @Before("execution(* webservice.*.*(..))")
    public void before(JoinPoint jp){
        log.info("Service: " + jp.getSignature().getName() + " Arguments: ");
        Object[] args = jp.getArgs();
        for(Object arg: args){
            log.info(arg);
        }
    }
}
