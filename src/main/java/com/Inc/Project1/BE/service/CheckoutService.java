package com.Inc.Project1.BE.service;

import java.util.List;
import java.util.Optional;

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

	// Find all
	public List<Checkout> getCheckout() {
		return this.repo.findAll();
	}

	// Find by ID
	public ResponseEntity<Checkout> getCheckout(int id) {
		Optional<Checkout> found = this.repo.findById(id);
		// If the given ID is empty then returns status not found
		if (found.isEmpty()) {
			return new ResponseEntity<Checkout>(HttpStatus.NOT_FOUND);
		}
		// If the given ID finds data then returns Checkout data
		Checkout body = found.get();
		return ResponseEntity.ok(body);
	}

	// Update by ID
	public ResponseEntity<Checkout> updateCheckout(int id, Checkout checkoutDetails) {
		Optional<Checkout> found = this.repo.findById(id);
		// If the given ID is empty then returns status not found
		if (found.isEmpty()) {
			return new ResponseEntity<Checkout>(HttpStatus.NOT_FOUND);
		}
		// If the given ID finds data then returns Checkout data
		Checkout exists = found.get();
		// If a field is not Null or 0 then set field input to XYZ
		if (checkoutDetails.getPhone() != null) {
			exists.setPhone(checkoutDetails.getPhone());
		}
		if (checkoutDetails.getEmail() != null) {
			exists.setEmail(checkoutDetails.getEmail());
		}

		// saves new data inside the fields and returns new data
		Checkout updated = this.repo.save(exists);
		return ResponseEntity.ok(updated);
	}

	// Remove by ID
	public boolean deleteCheckout(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
