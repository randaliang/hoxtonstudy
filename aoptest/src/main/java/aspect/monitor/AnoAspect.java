

package aspect.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 通过注解aop
 */
@Aspect
@Component
public class AnoAspect {


    @Pointcut("@annotation(aspect.service.AnnotationTag)")
    public void myPointcut() {
    }
	
	@Before("execution(* aspect..*Service.*(..))")
	public void before(JoinPoint joinPoint){
		System.out.println("@before: " + joinPoint.getSignature() );
	}
	
    @AfterReturning(value = "execution(* aspect..*Service.*(..))",returning = "result")
    public void doAfterReturningAdvice1(JoinPoint joinPoint,Object result){
    	System.out.println("@AfterReturning1："+result );
    }
    
    @Around("execution(* aspect..*Service.*(..))") 
    public Object aroundLogCalls(ProceedingJoinPoint jp) throws Throwable {  
    	System.out.println("@around" + jp.toString() );
        return jp.proceed();  
    }

 
    @AfterReturning(value = "execution(* aspect..*Service.*(..))",returning = "result",argNames = "result")
    public void doAfterReturningAdvice2(String result){
    	System.out.println("@AfterReturning2第二个后置返回通知的返回值："+result);
    }
 
    @After(value = "execution(* aspect..*Service.*(..))")
    public void doAfterAdvice(JoinPoint joinPoint){
    	System.out.println("@After后置通知执行了!");
    }
    
    
    @AfterThrowing(value = "execution(* aspect..*Service.*(..))",throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint,Throwable exception){
    	System.out.println("@AfterThrowing:" +exception.getClass() );
   
    }

    
    
    @Around("myPointcut()") 
    @Order(1)
    public Object aroundTag(ProceedingJoinPoint jp) throws Throwable {  
     	System.out.println("@around anno begin===========================");
    	Signature sig = jp.getSignature();
    	MethodSignature msig = null;
    	if (!(sig instanceof MethodSignature)) {
    		throw new IllegalArgumentException("该注解只能用于方法");
    	}
    	msig = (MethodSignature) sig;
    	Object target = jp.getTarget();
    	Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
    	
        Object o =  jp.proceed();
    	System.out.println("@around anno end=++++++++++++++++++++++++++++");
        return o;
    }


}
