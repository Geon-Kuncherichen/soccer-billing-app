package com.soccer_bill_splitter.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.soccer_bill_splitter.dto.ResponseDto;
import com.soccer_bill_splitter.dto.SignInDto;
import com.soccer_bill_splitter.dto.UserDto;
import com.soccer_bill_splitter.entity.User;
import com.soccer_bill_splitter.repository.UserRepository;
import com.soccer_bill_splitter.util.JwtUtil;
import com.soccer_bill_splitter.util.UtilService;
import com.soccer_bill_splitter.util.ValidationService;


@Service
public class UserServiceImpl implements UserService{
	
	Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ValidationService validationService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;

	@Override
	public ResponseDto saveUser(UserDto userDto) {
		try {
			//checking
			ResponseDto response=validationService.isValid(userDto);
			if(response.getStatus().equalsIgnoreCase("failed"))
				return response; 
			
			User user=new User();
			BeanUtils.copyProperties(userDto, user);
			user.setCreatedOn(new Date());
			user.setIsLoggedIn(true);
			userRepository.save(user);
			
			response=generateToken(user.getEmail(),user.getPassword());
			if(response.getStatus().equalsIgnoreCase("success"))
					 response.setMessage("User created succesfully");
			else
				response=UtilService.errorMessage("User failed to register");	
			
			return response;
		}catch(Exception e)
		{
			logger.error(e.getMessage(),e);
			return UtilService.errorMessage("User failed to register");
		}
		

	}
	
	
	private ResponseDto generateToken(String username,String password)
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		}catch(Exception e)
		{
			logger.error(e.getMessage(),e);
			logger.error("token failed to generate");
			return UtilService.errorMessage("User failed to register");
		}
		ResponseDto responseDto=UtilService.successMessage("token generated");
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("token", jwtUtil.generateToken(username));
		responseDto.setDetails(map);
		return responseDto; 
		
	}


	@Override
	public CompletableFuture<List<UserDto>> getUserNameList() {

		try {
			
			List<User>userNameList= userRepository.findAll();
			if(userNameList.isEmpty())
				return CompletableFuture.completedFuture(new ArrayList<>());
			
			List<UserDto>userDtoList=new ArrayList();
			
			//Map<Long,String>map=userNameList.stream().collect(HashMap::new,(k,v)->k.put(v.getUserId(),v.getUserName()),HashMap::putAll);
			return CompletableFuture.completedFuture(userNameList.stream().map(user->new UserDto(user.getUserId(),user.getUserName())).collect(Collectors.toList()));
		}catch(Exception e)
		{
			logger.error(e.getMessage(),e);
			return CompletableFuture.completedFuture(new ArrayList<>());
		}
	}


	@Override
	public ResponseDto signIn(@Valid SignInDto signInDto) {
		try {
			//checking
			ResponseDto response=new ResponseDto();
			
			Optional<User>userObj=userRepository.findByEmailAndPassword(signInDto.getEmail(),signInDto.getPassword());
			if(!userObj.isPresent())
				return UtilService.errorMessage("User not found");
			
			
			response=generateToken(userObj.get().getEmail(),userObj.get().getPassword());
			if(response.getStatus().equalsIgnoreCase("success"))
					 response.setMessage("Logged in succesfully");
			else
				response=UtilService.errorMessage("failed to login");	
			
			return response;
		}catch(Exception e)
		{
			logger.error(e.getMessage(),e);
			return UtilService.errorMessage("failed to login");
		}
		

	}
	
	
	
	

}
