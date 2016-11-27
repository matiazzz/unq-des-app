package webservice.logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//import java.util.Arrays;

@Aspect
public class LoggerService {

    //private static Logger log = Logger.getLogger(LoggerService.class);
    private static final Logger logger = LogManager.getLogger("HelloWorld");

    //@Before("within(webservice.*Rest) && execution(public * *(..))")
    @Before("execution(* webservice.EventRest.getMostPopular(..))")
    public void before(JoinPoint jp){
        logger.info("Hola");
    }

}
