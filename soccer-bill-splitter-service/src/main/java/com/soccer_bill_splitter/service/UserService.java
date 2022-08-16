package com.soccer_bill_splitter.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.soccer_bill_splitter.dto.ResponseDto;
import com.soccer_bill_splitter.dto.SignInDto;
import com.soccer_bill_splitter.dto.UserDto;

public interface UserService {

	ResponseDto saveUser(UserDto user);

	CompletableFuture<List<UserDto>> getUserNameList();

	ResponseDto signIn(@Valid SignInDto signInDto);

}
