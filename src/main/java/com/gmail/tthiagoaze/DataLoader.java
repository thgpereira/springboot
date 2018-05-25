package com.gmail.tthiagoaze;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.gmail.tthiagoaze.entity.User;
import com.gmail.tthiagoaze.service.UserService;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private UserService service;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		service.saveOrUpdate(new User("Thiago"));
		service.saveOrUpdate(new User("Lili"));
	}

}
