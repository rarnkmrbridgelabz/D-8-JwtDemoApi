package com.bridgelabz.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabz.dto.LoginDTO;
import com.bridgelabz.entity.User;
import com.bridgelabz.repository.UserRepository;
import com.bridgelabz.utility.TokenUtility;

@Service
public class UserService{
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TokenUtility tokenUtility;

	
	public User userRegister(User user){
		String encodedPassword= bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}

	
	public String userLogin(LoginDTO loginDTO) {
		Optional<User> userMailId = getUserByEmail(loginDTO.getEmailId());
		String token = tokenUtility.createToken(userMailId.get().getId());
		return token;
	}
	
	
	public Optional<User> getUserByEmail(String email){
		return userRepository.findByEmailId(email);
	}
	

}
