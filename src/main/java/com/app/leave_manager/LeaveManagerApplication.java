package com.app.leave_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LeaveManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaveManagerApplication.class, args);
	}

}
