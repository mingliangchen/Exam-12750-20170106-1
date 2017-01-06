package com.hand.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;
@Component("SpringClosedEvent")
public class SpringClosedEvent implements ApplicationListener<ApplicationEvent> {
    List<String> list = new ArrayList<String>();
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
         if(event instanceof ContextClosedEvent){
            System.out.println("spring 容器关闭了");
         }
    }

}
