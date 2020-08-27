package com.xwzj.spring.ioc;

import com.xwzj.spring.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

	@Bean
	Person person() {
		return Person.builder()
					 .age(18)
					 .name("kay")
					 .job("Java")
					 .build();
	}

	@Bean
	PersonServiceFactoryBean personServiceFactoryBean() {
		return new PersonServiceFactoryBean();
	}

}
