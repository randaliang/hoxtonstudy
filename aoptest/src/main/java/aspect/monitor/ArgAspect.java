package aspect.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author randaliang
 * @date 2021-06-13 20:57
 **/
@Aspect
@Component
public class ArgAspect {

    private final String POINT_CUT = "execution(public *  aspect.service.*.*(..))";

    @Pointcut(POINT_CUT)
    public void pointCut(){}

    //注意必须要有pointcut方法才可以启用，否则会报错
    @Before("pointCut() && args(aspect.common.model.User)")
//    @Before("args(aspect.common.model.User)")
    public void beforeAdd(JoinPoint jp){
        System.out.println("adduser"+ jp.getSignature().getName());
    }

}