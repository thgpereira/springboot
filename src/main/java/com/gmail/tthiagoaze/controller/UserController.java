package com.gmail.tthiagoaze.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gmail.tthiagoaze.entity.User;
import com.gmail.tthiagoaze.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		Optional<User> u = service.findById(id);
		if (u.isPresent()) {
			return ResponseEntity.ok(u.get());
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping(path = "/findby/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findById2(@PathVariable Long id) {
		User u = service.findById2(id);
		if (u != null) {
			return ResponseEntity.ok(u);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/find/{name}")
	public ResponseEntity<List<User>> findByName(@PathVariable String name) {
		List<User> u = service.findByName(name);
		if (u.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(u);
	}

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> u = service.findAll();
		if (u.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(u);
	}

	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user) {
		User u = service.saveOrUpdate(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<User> update(@RequestBody User user) {
		User u = service.saveOrUpdate(user);
		return ResponseEntity.ok(u);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		try {
			service.deleteById(id);
			return ResponseEntity.ok("Excluído com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao excluir!");
		}
	}

}
