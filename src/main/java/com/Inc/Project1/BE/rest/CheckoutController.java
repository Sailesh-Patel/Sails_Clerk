package com.Inc.Project1.BE.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	// Get all
	@GetMapping("/get")
	public List<Checkout> getCheckout() {
		return this.service.getCheckout();
	}

	// Get by ID
	@GetMapping("/get/{id}")
	public ResponseEntity<Checkout> getCheckout(@PathVariable int id) {
		return this.service.getCheckout(id);
	}

	// Update by ID
	@PatchMapping("/update/{id}")
	public ResponseEntity<Checkout> updateCheckout(@PathVariable int id, @RequestBody Checkout CheckoutDetails) {
		return this.service.updateCheckout(id, CheckoutDetails);
	}

	// Delete by ID
	@DeleteMapping("/delete/{id}")
	public boolean deleteCheckout(@PathVariable int id) {
		return this.service.deleteCheckout(id);
	}
}
