package com.Inc.Project1.BE.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inc.Project1.BE.domain.Reporting;
import com.Inc.Project1.BE.service.ReportingService;

@CrossOrigin
@RequestMapping("/reporting")
@RestController
public class ReportingController {

	private ReportingService service;

	public ReportingController(ReportingService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Reporting> createReporting(@RequestBody Reporting newReporting) {
		return this.service.createReporting(newReporting);
	}

	@GetMapping("/get")
	public List<Reporting> getReporting() {
		return this.service.getReporting();
	}

}
