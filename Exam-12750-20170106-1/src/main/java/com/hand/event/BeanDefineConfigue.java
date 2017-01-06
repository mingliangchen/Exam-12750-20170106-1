package com.hand.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
@Component("BeanDefineConfigue")
public class BeanDefineConfigue implements ApplicationListener<ContextRefreshedEvent> {
    List<String> list = new ArrayList<String>();
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        /*if(event instanceof ContextRefreshedEvent){
            System.out.println("spring容器被启动了");
        }*/
        /**
         * 在web 项目中（spring mvc），系统会存在两个容器，一个是root application context
         * ,另一个就是我们自己的 projectName-servlet context（作为root application context的子容器）。 
                                这种情况下，就会造成onApplicationEvent方法被执行两次。为了避免上面提到的问题，
                                我们可以只在root application context初始化完成后调用逻辑代码，其他的容器的初始化完成，则不做任何处理，修改后代码
         */
        if (event.getApplicationContext().getParent()==null) {//root application context 没有parent，他就是老大.  
            
            System.out.println("spring 容器启动了"+
              event.getApplicationContext().getDisplayName());
        }
        //再改
        /*if (event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")) {
            System.out.println("spring 容器启动了");
        }*/
        
    }

}
