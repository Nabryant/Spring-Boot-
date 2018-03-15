package com.example.chapter327;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ServletComponentScan
public class Chapter327Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter327Application.class, args);

	}
}
