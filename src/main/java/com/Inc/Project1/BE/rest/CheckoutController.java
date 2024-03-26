package com.Inc.Project1.BE.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inc.Project1.BE.domain.Checkout;
import com.Inc.Project1.BE.service.CheckoutService;

@RestController
@CrossOrigin
@RequestMapping("/checkout")
public class CheckoutController {

	private CheckoutService service;

	public CheckoutController(CheckoutService service) {
		super();
		this.service = service;
	}

	// Create
	@PostMapping("/create")
	public ResponseEntity<Checkout> createCheckout(@RequestBody Checkout newCheckout) {
		return this.service.createCheckout(newCheckout);
	}

}
