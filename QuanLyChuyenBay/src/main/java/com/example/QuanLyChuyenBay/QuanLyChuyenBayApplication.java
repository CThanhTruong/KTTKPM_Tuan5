package com.example.QuanLyChuyenBay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class QuanLyChuyenBayApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuanLyChuyenBayApplication.class, args);
	}
}
