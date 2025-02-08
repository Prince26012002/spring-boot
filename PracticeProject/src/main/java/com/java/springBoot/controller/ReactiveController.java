package com.java.springBoot.controller;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
//@MyCustomComponent
@RequestMapping("/reactive")
public class ReactiveController {

	// Returns a single value
	@GetMapping("/mono")
	public Mono<String> getMono() {
		return Mono.just("Hello");
	}

	// Returns a stream of values
	@GetMapping(value = "/flux", produces = "text/event-stream")
	public Flux<String> getStreamOfValues() {
		List<String> data = Arrays.asList("hello", "welcome", "to", "world", "of", "race");
		return Flux.fromIterable(data).delayElements(Duration.ofSeconds(1)).log();
	}

}
