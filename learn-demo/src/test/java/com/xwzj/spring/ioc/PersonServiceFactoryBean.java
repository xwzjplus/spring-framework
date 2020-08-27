package com.xwzj.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Dynamic set register bean to factory
 */
@Component
public class PersonServiceFactoryBean implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		DefaultListableBeanFactory factory = (DefaultListableBeanFactory) beanFactory;
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(
				com.xwzj.spring.ioc.DynamicService.class);

		beanDefinitionBuilder.addPropertyReference("person", "person");

		//1.register a bean
		factory.registerBeanDefinition("dynamicService", beanDefinitionBuilder.getRawBeanDefinition());

		//2.register a singleton bean
		factory.registerSingleton("dynamicService2", new com.xwzj.spring.ioc.DynamicService());
	}
}
