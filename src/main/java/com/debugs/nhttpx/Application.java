package com.debugs.nhttpx;

import com.debugs.nhttpx.concurrency.ShutdownHook;
import com.debugs.nhttpx.config.BeanConfiguration;
import com.debugs.nhttpx.manager.ProcessManager;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author van de Bugs <van.de.bugs@gmail.com>
 */
public class Application {
    
    private static Application application;
    
    private final ApplicationContext context;

    private Application(ApplicationContext context) {
        this.context = context;
    }
    
    public void start() throws Exception {
        ProcessManager manager = context.getBean(ProcessManager.class);
        manager.doProcess();
    }
    
    public void stop() throws IOException {
        ProcessManager manager = context.getBean(ProcessManager.class);
        manager.stop();
    }
    
    public static Application getInstance() {
        return application;
    }
    
    public static void main(String[] args) throws Exception {
        System.setProperty("log4j.configurationFile", "config/log4j2.xml");
        
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        application = new Application(context);
        
        Runtime runtime = Runtime.getRuntime();
        
        ShutdownHook hook = new ShutdownHook();
        runtime.addShutdownHook(hook);
        
        application.start();
    }
}
