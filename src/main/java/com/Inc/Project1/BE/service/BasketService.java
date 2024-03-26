package com.Inc.Project1.BE.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Inc.Project1.BE.domain.Basket;
import com.Inc.Project1.BE.repo.BasketRepo;

@Service
public class BasketService {

	private BasketRepo repo;

	public BasketService(BasketRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Basket> createBasket(Basket newBasket) {

		Basket created = this.repo.save(newBasket);

		return new ResponseEntity<Basket>(created, HttpStatus.CREATED);
	}

	public List<Basket> getBasket() {

		return this.repo.findAll();
	}

}