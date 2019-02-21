package com.slmanju.springreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
@SpringBootApplication
public class ReactiveWebMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveWebMongoApplication.class, args);
    }

}
