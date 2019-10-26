package com.sgic.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.ems.dto.UserDto;
import com.sgic.ems.dto.UserNameDto;
import com.sgic.ems.dto.mapping.DtoToEntityMapper;
import com.sgic.ems.entity.User;
import com.sgic.ems.entity.mapping.EntityToDtoMapper;
import com.sgic.ems.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private DtoToEntityMapper dtoToEntityMapper;
	@Autowired
	private EntityToDtoMapper entityToDtoMapper;

	
	@PostMapping("/user")
	public UserDto postRequestPromotion(@RequestBody UserDto dto) {

		return entityToDtoMapper.mapToUserDto(userService.addUser(
				dtoToEntityMapper.mapToUser(dto)));
				
		
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<String> updateUser(@PathVariable(name="id") Integer id,@RequestBody UserDto dto){
		User User=dtoToEntityMapper.mapToUser(dto);
		if(userService.editUser(User, id))
		{
			return new ResponseEntity<>("updated",HttpStatus.OK);
		}
		return new ResponseEntity<>("upadte failed", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/user")
	public ResponseEntity<List<UserDto>> getUser() {
		List<UserDto> UserDtoList =entityToDtoMapper.mapToUserDtoList(userService.getAllUser());
		ResponseEntity<List<UserDto>> response = new ResponseEntity<>(UserDtoList, HttpStatus.OK);
		return response;
	}

	@GetMapping("/user/{id}")
	public UserDto getOneById(@PathVariable("id") Integer User_id) {
		return entityToDtoMapper.mapToUserDto(userService.getById(User_id));
	}

	
	@DeleteMapping("/user/{id}")
	public HttpStatus deleteUser(@PathVariable("id") Integer id) {
		boolean test = userService.deleteUser(id);
		HttpStatus status;
		if (test) {
			return HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return status;
	}
	
	@GetMapping("/user/allUsers")
	public List<UserNameDto> getAllUserNames() {
		return userService.getAllUserNames();
	}
	
}
