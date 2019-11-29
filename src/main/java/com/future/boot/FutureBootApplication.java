package com.future.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.future.basic.framework.configuration.EnableFutureBasic;

@EnableFutureBasic
@SpringBootApplication
public class FutureBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FutureBootApplication.class, args);
	}

}
