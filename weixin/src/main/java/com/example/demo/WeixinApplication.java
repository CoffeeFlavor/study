package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication

public class WeixinApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeixinApplication.class, args);
	}
}
