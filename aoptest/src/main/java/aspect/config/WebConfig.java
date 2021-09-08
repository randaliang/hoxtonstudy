package aspect.config;

import aspect.invoke.MyInocationHander;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author randaliang
 * @date 2021-06-14 9:04
 **/
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private MyHandlerIntecepter myHandlerIntecepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(myHandlerIntecepter);
        // 排除配置
        addInterceptor.excludePathPatterns("/info");
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.addPathPatterns("/**");
    }


}

