package com.uts.springuts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringutsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringutsApplication.class, args);
	}

}
