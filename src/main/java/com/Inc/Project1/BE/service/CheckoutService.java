package com.Inc.Project1.BE.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Inc.Project1.BE.domain.Checkout;
import com.Inc.Project1.BE.repo.CheckoutRepo;

@Service
public class CheckoutService {
	private CheckoutRepo repo;

	public CheckoutService(CheckoutRepo repo) {
		super();
		this.repo = repo;
	}

	// Creating new
	public ResponseEntity<Checkout> createCheckout(Checkout newCheckout) {
		Checkout created = this.repo.save(newCheckout);
		return new ResponseEntity<Checkout>(created, HttpStatus.CREATED);
	}

}
