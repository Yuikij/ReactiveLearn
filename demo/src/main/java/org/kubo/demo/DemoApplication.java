package org.kubo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        GreetingClient greetingClient = context.getBean(GreetingClient.class);
        Greeting greeting = new Greeting();
        greeting.setMessage("1");
        // We need to block for the content here or the JVM might exit before the message is logged
        Mono<String> message1 = greetingClient.getMessage();
        Mono<String> messageSouKon = greetingClient.getMessage();
        Disposable subscribe = messageSouKon.subscribe((e) -> {
            System.out.println(greeting.getMessage() + ":" + Thread.currentThread().getName());
        });
        System.out.println("end get:" + Thread.currentThread().getName());
        greeting.setMessage("123");
    }

}
