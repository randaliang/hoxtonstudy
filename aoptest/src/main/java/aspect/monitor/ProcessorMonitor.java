package aspect.monitor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author randaliang
 * @date 2021-06-17 16:21
 **/
@Component
@Slf4j
public class ProcessorMonitor implements BeanPostProcessor {

    /*
    扫描controller的目录
     */
    @Value("${ctj.base.resoucescan}")
    private String scanDir;

    private List<String> pathList = new ArrayList<>();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(scanDir == null){
            scanDir = "com.ctj";
        }
        if( !bean.getClass().getPackage().getName().startsWith(scanDir)) {
            return bean;
        }
        RequestMapping m =bean.getClass().getAnnotation(RequestMapping.class);
        if( m != null && m.value().length>0){
            pathList.add(m.value()[0]);
        }
        return bean;
    }
}