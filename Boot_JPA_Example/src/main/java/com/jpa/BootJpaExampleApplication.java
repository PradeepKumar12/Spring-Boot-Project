package com.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.model.User;
import com.jpa.repository.UserRepository;

@SpringBootApplication
public class BootJpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext= SpringApplication.run(BootJpaExampleApplication.class, args);
		UserRepository userRepository=applicationContext.getBean(UserRepository.class);
		
		User user=new User();
		user.setId(1);
		user.setName("Ram");
		user.setCity("noida");
	
		User result=userRepository.save(user);
		System.out.println(result);
	
	}

}
