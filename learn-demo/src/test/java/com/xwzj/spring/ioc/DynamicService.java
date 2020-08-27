package com.xwzj.spring.ioc;

import com.xwzj.spring.model.Person;

public class DynamicService {
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
