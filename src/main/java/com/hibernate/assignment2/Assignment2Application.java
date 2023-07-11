package com.hibernate.assignment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Assignment2Application {

  public static void main(String[] args) {
    SpringApplication.run(Assignment2Application.class, args);
  }

}
