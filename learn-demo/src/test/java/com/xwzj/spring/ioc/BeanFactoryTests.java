package com.xwzj.spring.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.xwzj.spring.model.Person;
import com.xwzj.spring.po.Student;
import com.xwzj.spring.po.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTests {

	@Test
	void testApplicationContext() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/beans.xml");
		Person person = applicationContext.getBean("kay", Person.class);

		assertEquals("Java", person.getJob());
	}

	@Test
	void testBeanFactory() {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions(new ClassPathResource("ioc/beans.xml"));

		Person person = beanFactory.getBean("kay", Person.class);

		assertEquals("Java", person.getJob());
	}

	@Test
	void testAnnotationFactory() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				BeansConfig.class);

		Person person = context.getBean("person", Person.class);
		assertEquals(18, person.getAge());
	}

	@Test
	void testFactoryBean() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				BeansConfig.class);

		DynamicService dynamic = context.getBean("dynamicService", DynamicService.class);

		assertNotNull(dynamic.getPerson());
		assertEquals(18, dynamic.getPerson().getAge());

		DynamicService dynamicService2 = context.getBean("dynamicService2", DynamicService.class);
		assertNotNull(dynamicService2);
	}

	@Test
	void testCycleBeanByField() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.xwzj.spring.po");
		Student student = context.getBean("student", Student.class);
		Teacher teacher = context.getBean("teacher", Teacher.class);
		assertEquals(teacher, student.getTeacher());
	}
}
