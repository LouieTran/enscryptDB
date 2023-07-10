package com.example.encryptdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.encryptdb.repository")
public class EncryptdbApplication {
	public static void main(String[] args){
		SpringApplication.run(EncryptdbApplication.class, args);
	}
}
