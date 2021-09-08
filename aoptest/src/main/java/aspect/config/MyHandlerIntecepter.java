package aspect.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author randaliang
 * @date 2021-06-14 9:31
 **/
@Component
public class MyHandlerIntecepter implements HandlerInterceptor {

    NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("StopWatch-StartTime");

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     * 只有返回true才会继续向下执行，返回false取消当前请求
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        handler.toString();
        return true;
    }

}