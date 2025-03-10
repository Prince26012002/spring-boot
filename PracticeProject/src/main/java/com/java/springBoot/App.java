package com.java.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.EnableKafka;

import com.java.springBoot.componentConfiguration.MyComponentConfiguration;

@SpringBootApplication
@ComponentScan(basePackages = "com.java.springBoot", useDefaultFilters = false) // Disable default scanning
@Import(MyComponentConfiguration.class)
@EnableKafka
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
