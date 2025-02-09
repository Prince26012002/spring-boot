package com.java.springBoot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.springBoot.annotation.MyCustomAutowired;
import com.java.springBoot.annotation.MyCustomComponent;
import com.java.springBoot.processor.NotificationProcessor;

@RestController
@MyCustomComponent
@RequestMapping("/notification")
public class NotificationController {

	@MyCustomAutowired
	private NotificationProcessor notificationProcessor;

	@PostMapping("/send")
	public String sendNotification(@RequestParam String notificationType, @RequestBody String message) {
		notificationProcessor.sendNotification(notificationType, message);
		return "Notification sent via " + notificationType;
	}

}
