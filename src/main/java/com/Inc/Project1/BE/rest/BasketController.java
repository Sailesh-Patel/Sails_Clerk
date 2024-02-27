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

import com.Inc.Project1.BE.domain.Basket;
import com.Inc.Project1.BE.service.BasketService;

@CrossOrigin
@RequestMapping("/basket")
@RestController
public class BasketController {

	private BasketService service;

	public BasketController(BasketService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Basket> createBasket(@RequestBody Basket newBasket) {

		return this.service.createBasket(newBasket);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteBasket(@PathVariable int id) {

		return this.service.deleteBasket(id);
	}

	@GetMapping("/get")
	public List<Basket> getBasket() {

		return this.service.getBasket();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Basket> getBasket(@PathVariable int id) {

		return this.service.getBasket(id);

	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Basket> updateBasket(@PathVariable int id, @RequestBody Basket newBasket) {

		return this.service.updateBasket(id, newBasket);

	}

}
