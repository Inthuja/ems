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

import com.sgic.ems.dto.ProfessionalQualificationDto;
import com.sgic.ems.dto.mapping.DtoToEntityMapper;
import com.sgic.ems.entity.ProfessionalQualification;
import com.sgic.ems.entity.mapping.EntityToDtoMapper;
import com.sgic.ems.service.ProfessionalQualificationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProfessionalQualificationController {

	
	@Autowired
	private ProfessionalQualificationService professionalQualificationService;
	@Autowired
	private DtoToEntityMapper dtoToEntityMapper;
	@Autowired
	private EntityToDtoMapper entityToDtoMapper;

	
	@PostMapping("/professionalQualification")
	public HttpStatus postRequestPromotion(@RequestBody ProfessionalQualificationDto dto) {

		boolean test = professionalQualificationService.addProfessionalQualification(
				dtoToEntityMapper.mapToProfessionalQualification(dto));
				
		if (test) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PutMapping("/professionalQualification/{id}")
	public HttpStatus updateProfessionalQualification(@PathVariable(name="id") Integer id,@RequestBody ProfessionalQualificationDto dto){
		ProfessionalQualification professionalQualification=dtoToEntityMapper.mapToProfessionalQualification(dto);
		if(professionalQualificationService.editProfessionalQualification(professionalQualification, id))
		{
			return HttpStatus.OK;
		}
		return  HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/professionalQualification")
	public ResponseEntity<List<ProfessionalQualificationDto>> getProfessionalQualification() {
		List<ProfessionalQualificationDto> professionalQualificationDtoList =entityToDtoMapper.mapToProfessionalQualificationDtoList(professionalQualificationService.getAllProfessionalQualification());
		ResponseEntity<List<ProfessionalQualificationDto>> response = new ResponseEntity<>(professionalQualificationDtoList, HttpStatus.OK);
		return response;
	}

	@GetMapping("/professionalQualification/{id}")
	public ProfessionalQualificationDto getOneById(@PathVariable("id") Integer professionalQualification_id) {
		return entityToDtoMapper.mapToProfessionalQualificationDto(professionalQualificationService.getById(professionalQualification_id));
	}

	
	@DeleteMapping("/professionalQualification/{id}")
	public HttpStatus deleteProfessionalQualification(@PathVariable("id") Integer id) {
		boolean test = professionalQualificationService.deleteProfessionalQualification(id);
		HttpStatus status;
		if (test) {
			return HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return status;
	}
	
	@GetMapping("/professionalQualification/user/{id}")
	public List<ProfessionalQualificationDto> getByUser(@PathVariable("id") Integer id) {
		return entityToDtoMapper.mapToProfessionalQualificationDtoList(professionalQualificationService.getAllProfessionalQualificationByUser(id));
	}
}
