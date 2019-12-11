package pl.javastart.service.aspects;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.*;
import java.time.Instant;

import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
@Component
public class TimeLoggerAspect {

	
	@Around("execution(* pl.javastart.service.BookRepository.get(..))")
	public Object logInfoAround(ProceedingJoinPoint pjp) throws Throwable   {
	
		Instant before = Instant.now();
		
		try {
		
			Object result = pjp.proceed();
			return result;
		
		} finally{
		
			Instant after = Instant.now();
			Duration execTime = Duration.between(before, after);
			System.out.println(pjp.toShortString() + " CZAS: " + execTime.toMillisPart());
		
		}
	
	
	}
	
}	

