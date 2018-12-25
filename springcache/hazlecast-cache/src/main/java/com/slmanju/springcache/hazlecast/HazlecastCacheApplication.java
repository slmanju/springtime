package com.slmanju.springcache.hazlecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HazlecastCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(HazlecastCacheApplication.class, args);
	}

}

