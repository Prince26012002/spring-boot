package com.java.springBoot.annotationPostProcessor;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;

import com.java.springBoot.annotation.MyCustomAutowired;
import com.java.springBoot.annotation.MyCustomComponent;

@MyCustomComponent
public class MyCustomAutowiredAnnotationPostProcessor implements BeanPostProcessor {

	@Autowired
	private ApplicationContext applicationContext;

	@SuppressWarnings("serial")
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(MyCustomAutowired.class)) {
				// Find the bean of the required type in the application context
				Object dependency = applicationContext.getBean(field.getType());
				if (dependency != null) {
					field.setAccessible(true);
					try {
						// Inject the dependency
						field.set(bean, dependency);
					} catch (IllegalAccessException e) {
						throw new BeansException("Failed to inject dependency", e) {
						};
					}
				}
			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
