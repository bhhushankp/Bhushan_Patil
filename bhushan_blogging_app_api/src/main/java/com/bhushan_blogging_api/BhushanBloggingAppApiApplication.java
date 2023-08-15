package com.bhushan_blogging_api;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BhushanBloggingAppApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BhushanBloggingAppApiApplication.class, args);
	}
	
	@Bean 
	public ModelMapper mp()
	{
		return new ModelMapper();
	}

}
