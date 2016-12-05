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
        log.info("Service: " + jp.getSignature().getName() + " Arguments: " + this.getArguments(jp));
    }

    private String getArguments(JoinPoint jp){
        String arguments = "";
        Object[] jpArgs = jp.getArgs();

        for(Object arg: jpArgs){
            arguments = arguments + " " + arg;
        }

        return arguments;
    }
}
