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

import com.sgic.ems.dto.RoleDto;
import com.sgic.ems.dto.mapping.DtoToEntityMapper;
import com.sgic.ems.entity.Role;
import com.sgic.ems.entity.mapping.EntityToDtoMapper;
import com.sgic.ems.service.RoleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private DtoToEntityMapper dtoToEntityMapper;
	@Autowired
	private EntityToDtoMapper entityToDtoMapper;

	
	@PostMapping("/role")
	public HttpStatus postRequestPromotion(@RequestBody RoleDto dto) {

		boolean test = roleService.addRole(
				dtoToEntityMapper.mapToRole(dto));
				
		if (test) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PutMapping("/role/{id}")
	public ResponseEntity<String> updateRole(@PathVariable(name="id") Integer id,@RequestBody RoleDto dto){
		Role role=dtoToEntityMapper.mapToRole(dto);
		if(roleService.editRole(role, id))
		{
			return new ResponseEntity<>("updated",HttpStatus.OK);
		}
		return new ResponseEntity<>("upadte failed", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/role")
	public ResponseEntity<List<RoleDto>> getRole() {
		List<RoleDto> roleDtoList =entityToDtoMapper.mapToRoleDtoList(roleService.getAllRole());
		ResponseEntity<List<RoleDto>> response = new ResponseEntity<>(roleDtoList, HttpStatus.OK);
		return response;
	}

	@GetMapping("/role/{id}")
	public RoleDto getOneById(@PathVariable("id") Integer role_id) {
		return entityToDtoMapper.mapToRoleDto(roleService.getById(role_id));
	}

	
	@DeleteMapping("/role/{id}")
	public HttpStatus deleteRole(@PathVariable("id") Integer id) {
		boolean test = roleService.deleteRole(id);
		HttpStatus status;
		if (test) {
			return HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return status;
	}
	
}
