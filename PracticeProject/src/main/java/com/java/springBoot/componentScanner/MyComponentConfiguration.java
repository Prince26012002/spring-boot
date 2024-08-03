package com.java.springBoot.componentScanner;

import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import com.java.springBoot.annotation.MyCustomComponent;

@Configuration
public class MyComponentConfiguration implements ImportBeanDefinitionRegistrar {

	@SuppressWarnings("unused")
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);

		// Add a filter to include classes annotated with @MyCustomComponent
		scanner.addIncludeFilter(new AnnotationTypeFilter(MyCustomComponent.class));

		// Scan the base package (you can change the package according to your needs)
		Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents("com.java.springBoot");

		for (BeanDefinition beanDefinition : candidateComponents) {
			GenericBeanDefinition definition = (GenericBeanDefinition) beanDefinition;
			String beanClassName = definition.getBeanClassName();

			try {
				Class<?> beanClass = Class.forName(beanClassName);
				registry.registerBeanDefinition(beanClassName, definition);
			} catch (ClassNotFoundException e) {
				e.printStackTrace(); // Handle the exception appropriately
			}
		}
	}
}