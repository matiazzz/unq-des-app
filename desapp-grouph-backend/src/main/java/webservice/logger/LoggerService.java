package webservice.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//import java.util.Arrays;

@Aspect
public class LoggerService {

    private static Logger log = Logger.getLogger(LoggerService.class);

    @Before("within(webservice.*Rest) && execution(public * *(..))")
    public void before(JoinPoint jp){log.info("Hola");}

}
