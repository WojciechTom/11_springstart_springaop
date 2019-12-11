package pl.javastart.service.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

	
	@Before("execution(* pl.javastart.service.BookRepository.get(..))")
		public void logInfoBefore(JoinPoint jp) {
		Object[] args = jp.getArgs();
		System.out.println("Log Before method " + jp.getSignature());
		System.out.println("INFO BEFORE" + Arrays.toString(args));
	}


	@After("execution(* pl.javastart.service.BookRepository.get(..))")
	public void logInfoAfter(JoinPoint jp) {
		Object[] args = jp.getArgs();
 		System.out.println("Log After method " + jp.getSignature());
 		System.out.println("INFO AFTER " + Arrays.toString(args));
	}

	
	@AfterThrowing("execution(* pl.javastart.service.BookRepository.*(..))")
	public void logError() {
		System.out.println("Log Error!!!!!");
	}
	

	@AfterReturning("execution(* pl.javastart.service.BookRepository.get(..))")
	public void logSuccess(JoinPoint jp) {
		Object[]args = jp.getArgs();
		System.out.println("Method Successuflly returned");
		System.out.println("INFO SUCCESS " + Arrays.toString(args));
	}
	
	
}
