package com.flowerShop.flowershop.controller;

import java.security.MessageDigest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flowerShop.flowershop.model.User;
import com.flowerShop.flowershop.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public User addUser(@RequestBody User user) {
		user.setPassword(encodePassword(user.getPassword()));
		return userRepository.save(user);

	}
	
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public User login(@RequestBody User user) {
		//user.setPassword(encodePassword(user.getPassword()));
		User loginUser=this.getUserByEmail(user.getEmail());
		if(loginUser==null) {
			return null;
		}else {
			if (encodePassword(user.getPassword()).equals(loginUser.getPassword())) {
				return loginUser;
			}
		}
		
		return null;
		//return userRepository.save(user);

	}

	@GetMapping("/{email}")
	public User getUserByEmail(@PathVariable("email") String email) {
		return userRepository.getOne(email);
	}

	private String encodePassword(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
