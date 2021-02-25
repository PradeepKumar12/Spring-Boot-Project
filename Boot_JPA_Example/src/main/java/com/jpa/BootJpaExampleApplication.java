package com.jpa;

import java.util.ArrayList;
import java.util.List;

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
		
		
//		User user=new User();
//		user.setId(1);
//		user.setName("Ram");
//		user.setCity("noida");
//// Saving Single User		
//		User result=userRepository.save(user);
//		System.out.println(result);
//		
		
		User user1=new User();
		user1.setName("Mohan");
		user1.setCity("NCR");
	
		User user2=new User();
		user2.setName("Rohan");
		user2.setCity("RBL");
		
		List<User> list=List.of(user1,user2);
		Iterable<User> it =userRepository.saveAll(list);
		it.forEach(result->{
			System.out.println(result);
		});
	
		
	}

}
