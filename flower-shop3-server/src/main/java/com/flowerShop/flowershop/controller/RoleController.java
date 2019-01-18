package com.flowerShop.flowershop.controller;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flowerShop.flowershop.model.Role;
import com.flowerShop.flowershop.repository.RoleRepository;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleRepository roleRepository;

	@GetMapping
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Role addRole(@RequestBody Role role) throws ValidationException {
		return roleRepository.save(role);

	}

	@GetMapping("/{id_role}")
	public Role getRoleById(@PathVariable("id_role") int idRole) {
		return roleRepository.getOne(idRole);
	}

	@DeleteMapping("delete/{id_role}")
	public ResponseEntity<?> deleterRole(@PathVariable(value = "id_role") Integer id_role) {
		Role role = roleRepository.getOne(id_role);
		roleRepository.delete(role);
		return ResponseEntity.ok().build();
	}

}
