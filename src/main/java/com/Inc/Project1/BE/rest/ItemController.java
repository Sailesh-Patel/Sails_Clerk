package com.Inc.Project1.BE.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inc.Project1.BE.domain.Item;
import com.Inc.Project1.BE.service.ItemServices;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {

	private ItemServices service;

	public ItemController(ItemServices service) {
		super();
		this.service = service;
	}

	// Create Items
	@PostMapping("/create")
	public ResponseEntity<Item> createItem(@RequestBody Item newItem) {
		return this.service.createItem(newItem);
	}

	// Get all items
	@GetMapping("/get")
	public List<Item> getItems() {
		return this.service.getItems();
	}

	// Get items by ID
	@GetMapping("/get/{id}")
	public ResponseEntity<Item> getItem(@PathVariable int id) {
		return this.service.getItem(id);
	}

	// Update items by ID
	@PutMapping("/update/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable int id, @RequestBody Item itemDetails) {
		return this.service.updateItem(id, itemDetails);
	}

	// Add item to basket
	@PatchMapping("add/{itemId}/{basketId}")
	public ResponseEntity<Object> addToBasket(@PathVariable int itemId, @PathVariable int basketId) {
		return this.service.addToBasket(itemId, basketId);
	}

	// Remove item from basket
	@PatchMapping("remove/{itemId}")
	public ResponseEntity<Object> removeFromBasket(@PathVariable int itemId) {
		return this.service.removeFromBasket(itemId);
	}

	// Delete items by ID
	@DeleteMapping("/delete/{id}")
	public boolean deleteItem(@PathVariable int id) {
		return this.service.deleteItem(id);
	}
}
