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

import com.sgic.ems.dto.AuthDto;
import com.sgic.ems.dto.LoginDto;
import com.sgic.ems.dto.LoginRequestDto;
import com.sgic.ems.dto.mapping.DtoToEntityMapper;
import com.sgic.ems.entity.Login;
import com.sgic.ems.entity.mapping.EntityToDtoMapper;
import com.sgic.ems.service.LoginService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private DtoToEntityMapper dtoToEntityMapper;
	@Autowired
	private EntityToDtoMapper entityToDtoMapper;

	
	@PostMapping("/login")
	public HttpStatus postRequestPromotion(@RequestBody LoginDto dto) {

		boolean test = loginService.addLogin(
				dtoToEntityMapper.mapToLogin(dto));
				
		if (test) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PutMapping("/login/{id}")
	public ResponseEntity<String> updateLogin(@PathVariable(name="id") Integer id,@RequestBody LoginDto dto){
		Login login=dtoToEntityMapper.mapToLogin(dto);
		if(loginService.editLogin(login, id))
		{
			return new ResponseEntity<>("updated",HttpStatus.OK);
		}
		return new ResponseEntity<>("upadte failed", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/login")
	public ResponseEntity<List<LoginDto>> getLogin() {
		List<LoginDto> loginDtoList =entityToDtoMapper.mapToLoginDtoList(loginService.getAllLogin());
		ResponseEntity<List<LoginDto>> response = new ResponseEntity<>(loginDtoList, HttpStatus.OK);
		return response;
	}

	@GetMapping("/login/{id}")
	public LoginDto getOneById(@PathVariable("id") Integer login_id) {
		return entityToDtoMapper.mapToLoginDto(loginService.getById(login_id));
	}

	
	@DeleteMapping("/login/{id}")
	public HttpStatus deleteLogin(@PathVariable("id") Integer id) {
		boolean test = loginService.deleteLogin(id);
		HttpStatus status;
		if (test) {
			return HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return status;
	}
	
	@PostMapping("/login/authenticate")
	public ResponseEntity<AuthDto>  authenticate(@RequestBody LoginRequestDto request) {
		AuthDto auth = loginService.authenticate(request.getUsername(), request.getPassword());
		
		if (auth != null) {
			return new ResponseEntity<AuthDto>(auth, HttpStatus.OK);
		} 
		return new ResponseEntity<AuthDto>(HttpStatus.BAD_REQUEST);
	}
}
