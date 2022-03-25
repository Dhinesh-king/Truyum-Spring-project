package com.cognizant.truyum;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.truyum.dao.ConnectionHandler;
import com.cognizant.truyum.util.DateUtil;

@SpringBootApplication
public class TruyumApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruyumApplication.class, args);
	}

}
