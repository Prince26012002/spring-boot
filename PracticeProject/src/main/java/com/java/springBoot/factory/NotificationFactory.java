package com.java.springBoot.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.springBoot.annotation.MyCustomComponent;
import com.java.springBoot.service.NotificationService;

import jakarta.annotation.PostConstruct;

@MyCustomComponent
public class NotificationFactory {

	private List<NotificationService> notificationServices;

	private Map<String, NotificationService> notificationServicesMap = new HashMap<String, NotificationService>();

	// In future will make change for support Custom Autowired in constructor
	// injection
	// Autowired is not required in case of single constructor method, just putting
	// it for identifying purpose as dependencies is getting injected here
	@Autowired
	public NotificationFactory(List<NotificationService> notificationServices) {
		this.notificationServices = notificationServices;
	}

	@PostConstruct
	public void buildNotificationServices() {
		this.notificationServices.forEach(notificationService -> notificationServicesMap
				.put(notificationService.getNotificationType(), notificationService));
	}

	public NotificationService getNotificationService(String notificationType) {
		return this.notificationServicesMap.get(notificationType);
	}

}
