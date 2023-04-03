package com.MyCrudApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.Arrays;

@SpringBootApplication
public class MyCruDappApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyCruDappApplication.class, args);
	}
}
