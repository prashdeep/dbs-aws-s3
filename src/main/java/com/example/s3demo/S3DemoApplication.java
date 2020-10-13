package com.example.s3demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class S3DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(S3DemoApplication.class, args);
	}

	@Override
	public void run(String args[]){
		System.out.println(" Inside the spring boot application ....");
	}

}
