package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/message")
	public Message message() {
		return new Message("Hello Jürgen");
	}

	public record Message(String content) {}
}
