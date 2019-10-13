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

import com.sgic.ems.dto.AcadamicQualificationDto;
import com.sgic.ems.dto.mapping.DtoToEntityMapper;
import com.sgic.ems.entity.AcadamicQualification;
import com.sgic.ems.entity.mapping.EntityToDtoMapper;
import com.sgic.ems.service.AcadamicQualificationService;

@RestController
public class AcadamicQualificationController {

	@Autowired
	private AcadamicQualificationService acedemicQualificationService;
	@Autowired
	private DtoToEntityMapper dtoToEntityMapper;
	@Autowired
	private EntityToDtoMapper entityToDtoMapper;

	
	@PostMapping("/acedemicQualification")
	public HttpStatus postRequestPromotion(@RequestBody AcadamicQualificationDto dto) {

		boolean test = acedemicQualificationService.addAcedemicQualification(
				dtoToEntityMapper.mapToAccadamicQualification(dto));
				
		if (test) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PutMapping("/acedemicQualification/{id}")
	public ResponseEntity<String> updateAcedemicQualification(@PathVariable(name="id") Integer id,@RequestBody AcadamicQualificationDto dto){
		AcadamicQualification acedemicQualification=dtoToEntityMapper.mapToAccadamicQualification(dto);
		if(acedemicQualificationService.editAcedemicQualification(acedemicQualification, id))
		{
			return new ResponseEntity<>("updated",HttpStatus.OK);
		}
		return new ResponseEntity<>("upadte failed", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/acedemicQualification")
	public ResponseEntity<List<AcadamicQualificationDto>> getAcedemicQualification() {
		List<AcadamicQualificationDto> acedemicQualificationDtoList =entityToDtoMapper.mapToAcadamicQualificationDtoList(acedemicQualificationService.getAllAcedemicQualification());
		ResponseEntity<List<AcadamicQualificationDto>> response = new ResponseEntity<>(acedemicQualificationDtoList, HttpStatus.OK);
		return response;
	}

	@GetMapping("/acedemicQualification/{id}")
	public AcadamicQualificationDto getOneById(@PathVariable("id") Integer accadamicQualification_id) {
		return entityToDtoMapper.mapToAccadamicQualificationDto(acedemicQualificationService.getById(accadamicQualification_id));
	}

	
	@DeleteMapping("/acedemicQualification/{id}")
	public HttpStatus deleteAcedemicQualification(@PathVariable("id") Integer id) {
		boolean test = acedemicQualificationService.deleteAcedemicQualification(id);
		HttpStatus status;
		if (test) {
			return HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return status;
	}
}
