package com.java.springBoot.service.impl;

import org.springframework.stereotype.Service;

import com.java.springBoot.annotation.MyCustomComponent;
import com.java.springBoot.service.NotificationService;

@Service
@MyCustomComponent
public class CallNotificationService implements NotificationService {

	@Override
	public String getNotificationType() {
		return "Call";
	}

	@Override
	public void sendNotification(String message) {
		System.out.println("Message Received via " + "Call -> " + message);
	}
}
