package com.springProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserLoginController {
	
	@GetMapping("/example")
    public String getExample() {
			return "This is an example endpoint";
    }

}