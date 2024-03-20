package com.lkj.getapi;

import com.lkj.getapi.service.AppRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GetapiApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GetapiApplication.class, args);
		AppRunner appRunner = new AppRunner();
		appRunner.run();
	}

}
