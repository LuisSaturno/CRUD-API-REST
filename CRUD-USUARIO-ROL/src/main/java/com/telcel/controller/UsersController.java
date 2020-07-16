package com.telcel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telcel.dao.IUsuarioDAO;
import com.telcel.entities.Usuario;

/*
 * @author Jose Luis Castillo
 * */
@RestController
@RequestMapping("telcel")
public class UsersController {

	@Autowired
	private IUsuarioDAO userDAO;

	@GetMapping()
	public ResponseEntity<List<Usuario>> getUsers() {
		List<Usuario> users = userDAO.findAll();
		return ResponseEntity.ok(users);
	}

	@RequestMapping("users/{userID}")
	public ResponseEntity<Usuario> getUsersById(@PathVariable int userID) {
		Optional<Usuario> opUsers = userDAO.findById(userID);
		if (opUsers.isPresent()) {
			return ResponseEntity.ok(opUsers.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@RequestMapping("user/{username}")
	public ResponseEntity<Usuario> getUsersByName(@PathVariable String username) {

		Optional<Usuario> opUsers = Optional.of(userDAO.findByNombre(username));
		if (opUsers.isPresent()) {

			return ResponseEntity.ok(opUsers.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping("create")
	public ResponseEntity<Usuario> createUser(@RequestBody Usuario user) {
		return ResponseEntity.ok(userDAO.save(user));
	}

	@PutMapping("update")
	public ResponseEntity<Usuario> updateUser(@RequestBody Usuario user) {
		Optional<Usuario> opUsers = userDAO.findById(user.getId());
		if (opUsers.isPresent()) {
			Usuario updateUser = opUsers.get();
			updateUser.setNombre(user.getNombre());
			updateUser.setA_Paterno(user.getA_Paterno());
			updateUser.setA_Materno(user.getA_Materno());
			updateUser.setRol(user.getRol());
			userDAO.save(updateUser);
			return ResponseEntity.ok(updateUser);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@DeleteMapping("delete/{userID}")
	public void deleteUsers(@PathVariable int userID) {
		userDAO.deleteById(userID);
	}

}
