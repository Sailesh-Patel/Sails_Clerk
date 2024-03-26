package com.Inc.Project1.BE.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/get")
	public List<Basket> getBasket() {

		return this.service.getBasket();
	}

}
