package com.sgic.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.ems.dto.ExperienceDto;
import com.sgic.ems.dto.mapping.DtoToEntityMapper;
import com.sgic.ems.entity.mapping.EntityToDtoMapper;
import com.sgic.ems.service.ExperienceService;

@RestController
public class ExperienceController {

	@Autowired
	private ExperienceService experienceService;
	@Autowired
	private DtoToEntityMapper dtoToEntityMapper;
	@Autowired
	private
	EntityToDtoMapper entityToDtoMapper;
	
	@PostMapping("/experience")
	public HttpStatus postRequestPromotion(@RequestBody ExperienceDto dto) {

		boolean test = experienceService.addExperience(
				dtoToEntityMapper.mapToExperiene(dto));
				
		if (test) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PutMapping("/experience/{id}")
	public ResponseEntity<String> updateExperience(@PathVariable(name="id") Integer id,@RequestBody ExperienceDto dto){
		
		if(experienceService.editExperience(dtoToEntityMapper.mapToExperiene(dto), id))
		{
			return new ResponseEntity<>("updated",HttpStatus.OK);
		}
		return new ResponseEntity<>("upadte failed", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/experience")
	public ResponseEntity<List<ExperienceDto>> getExperience() {
		List<ExperienceDto> experienceList = entityToDtoMapper.mapToExperieneDtoList(experienceService.getAllExperience());
		ResponseEntity<List<ExperienceDto>> response = new ResponseEntity<>(experienceList, HttpStatus.OK);
		return response;
	}

	@GetMapping("/experience/{id}")
	public ExperienceDto getOneById(@PathVariable("id") Integer user_id) {
		return entityToDtoMapper.mapToExperieneDto(experienceService.getById(user_id));
	}

	
	@DeleteMapping("/experience/{id}")
	public HttpStatus deleteExperience(@PathVariable("id") Integer id) {
		boolean test = experienceService.deleteExperience(id);
		HttpStatus status;
		if (test) {
			return HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return status;
	}

}
