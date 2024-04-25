package com.Inc.Project1.BE.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Inc.Project1.BE.domain.Reporting;
import com.Inc.Project1.BE.repo.ReportingRepo;

@Service
public class ReportingService {

	private ReportingRepo repo;

	public ReportingService(ReportingRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Reporting> createReporting(Reporting newReporting) {
		Reporting created = this.repo.save(newReporting);
		return new ResponseEntity<Reporting>(created, HttpStatus.CREATED);
	}

	public List<Reporting> getReporting() {

		return this.repo.findAll();
	}

}
