package com.trim.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.trim.scheduler.config")
public class SchedulerApplication {

	public static void main(String[] args) {

		SpringApplication.run(SchedulerApplication.class, args);
	}

}
