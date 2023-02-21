package com.udacity.c1.review;

import com.udacity.c1.review.services.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;


@ComponentScan(basePackages = {"com.udacity.c1.review"})
@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}
//	@Primary
	@Bean
	public String helloSpring(){
		System.out.println("Message");
		return "Hello, Spring";
	}
//
//	@Bean
//	public String upperCaseMessageDependent(MessageService messageService){
//		System.out.println(messageService.uppercaseMessage());
//		return messageService.uppercaseMessage();
//	}
//
//	@Bean
//	public String lowerCaseMessageDependent(MessageService messageService){
//		System.out.println(messageService.lowercaseMessage());
//		return messageService.lowercaseMessage();
//	}

//	@Primary
//	@Bean
//	public String basicMessage(){
//		System.out.println("inside baciMessage");
//		return "Hello";
//	}
//
//	@Bean
//	public String compoundMessage(String bbM){
//		System.out.println(bbM + "inside compound message");
//		return "Compound";
//	}
//
//	@Bean
//	public String wahalaMessage(String message){
//		System.out.println(message + "Inside wahala");
//		return "Wahala";
//	}

}
