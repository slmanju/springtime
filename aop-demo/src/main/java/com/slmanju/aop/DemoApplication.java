package com.slmanju.aop;

import com.slmanju.aop.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import static java.lang.System.exit;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final ApplicationContext context;

    @Autowired
    public DemoApplication(ApplicationContext context) {
        this.context = context;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        DemoService demoService = context.getBean(DemoService.class);
        demoService.method1();
        System.out.println("---------------------------");
        demoService.method2("spring aop in action", 5);
        System.out.println("---------------------------");
        demoService.method3();

        exit(0);
    }
}
