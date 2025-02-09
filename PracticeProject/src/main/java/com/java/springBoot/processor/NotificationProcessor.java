package com.java.springBoot.processor;

import com.java.springBoot.annotation.MyCustomComponent;
import com.java.springBoot.factory.NotificationFactory;
import com.java.springBoot.service.NotificationService;

@MyCustomComponent
public class NotificationProcessor {

	private final NotificationFactory notificationFactory;

	public NotificationProcessor(NotificationFactory notificationFactory) {
		this.notificationFactory = notificationFactory;
	}

	public void sendNotification(String notificationType, String message) {
		NotificationService service = notificationFactory.getNotificationService(notificationType);
		if (service == null) {
			System.out.println("No Service Found based on Notification Type received");
			return;
		}
		service.sendNotification(message);
	}

}
