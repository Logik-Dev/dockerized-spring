package fr.logikdev.dockerized.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.logikdev.dockerized.models.User;
import fr.logikdev.dockerized.repositories.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		List<User> users = userRepository.findAll();
		if(!users.isEmpty()) {
			return ResponseEntity.ok(users);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun résultat");
	
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun Résultat");
		}
	}
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user){
		return ResponseEntity.ok(userRepository.save(user));
	}
}
