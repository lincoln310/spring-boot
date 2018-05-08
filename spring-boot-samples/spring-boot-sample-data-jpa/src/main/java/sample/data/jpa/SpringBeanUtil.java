package sample.data.jpa;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by linpeng on 16-1-21.
 */

@Component
public class SpringBeanUtil implements ApplicationContextAware {

    static ApplicationContext context = null;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanUtil.setContext(applicationContext);
    }

    static public void setContext(ApplicationContext context) throws BeansException {
        SpringBeanUtil.context = context;
    }

    public static ApplicationContext getApplicationContext(){
        return SpringBeanUtil.context;
    }

    public static Object getBean(String beanName){
        if (context == null) {
            //context = new ClassPathXmlApplicationContext("classpath:spring.xml");
            throw new NullPointerException("ApplicationContext is null");
        }
        return context.getBean(beanName);
    }

}
