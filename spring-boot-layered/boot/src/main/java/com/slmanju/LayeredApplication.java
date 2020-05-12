package com.slmanju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.slmanju" })
public class LayeredApplication {

  public static void main(String[] args) {
    SpringApplication.run(LayeredApplication.class, args);
  }

}
