package webservice.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.BasicConfigurator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

//import java.util.Arrays;

@Aspect
@Order(1)
public class LoggerService {

    public final static Logger log = Logger.getLogger(LoggerService.class);

    @Before("execution(* webservice.*.*(..))")
    public void before(JoinPoint jp){
        log.info("*****************************************************");
    }

    public LoggerService(){PropertyConfigurator.configure("src/main/resources/log4j.properties");}

}
