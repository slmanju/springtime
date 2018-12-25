package com.slmanju.cache.simplecache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SimpleCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCacheApplication.class, args);
	}

}

