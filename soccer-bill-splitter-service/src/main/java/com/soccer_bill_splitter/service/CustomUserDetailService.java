package com.soccer_bill_splitter.service;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.soccer_bill_splitter.entity.User;
import com.soccer_bill_splitter.repository.UserRepository;


@Service
public class CustomUserDetailService implements UserDetailsService{

	Logger logger = LogManager.getLogger(UserServiceImpl.class);

	
	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username)  {

		try {
			Optional<User> user=	Optional.of(userRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("username: "+username+" not found")));
			return new org.springframework.security.core.userdetails.User(user.get().getEmail(),user.get().getPassword(),new ArrayList());
		}catch(UsernameNotFoundException exe)
		{
			logger.error(exe.getMessage());
			return new org.springframework.security.core.userdetails.User("nothing","nothing",new ArrayList());
		}
	
	
			
		
	}

}
