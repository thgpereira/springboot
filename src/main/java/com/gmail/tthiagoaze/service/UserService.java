package com.gmail.tthiagoaze.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.tthiagoaze.entity.User;
import com.gmail.tthiagoaze.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return (List<User>) repository.findAll();
	}

	public List<User> findByName(String name) {
		return repository.findByNameContainingIgnoreCase(name);
	}

	public Optional<User> findById(Long id) {
		return repository.findById(id);
	}

	public User saveOrUpdate(User user) {
		return repository.save(user);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public User findById2(Long id) {
		return repository.findById2(id);
	}

}
