package np.com.csangharsha.fusecanteen.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut(value = "execution(* np.com.csangharsha.fusecanteen.domains.*.*Repository.*(..))")
    public void repoPointCut() {

    }

    @Around("repoPointCut()")
    public Object getAllRepositoryLog(ProceedingJoinPoint joinPoint) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        String className = joinPoint.getSignature().getDeclaringType().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info(
                String.format("%s.%s(%s)", className, methodName, args)
        );

        return joinPoint.proceed();

    }
}
