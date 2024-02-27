package com.Inc.Project1.BE.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Inc.Project1.BE.domain.Item;
import com.Inc.Project1.BE.repos.ItemRepo;

@Service
public class ItemServices {
	private ItemRepo repo;

	public ItemServices(ItemRepo repo) {
		super();
		this.repo = repo;
	}

	// Creating new item
	public ResponseEntity<Item> createItem(Item newItem) {
		Item created = this.repo.save(newItem);
		return new ResponseEntity<Item>(created, HttpStatus.CREATED);
	}

	// Find all items
	public List<Item> getItems() {
		return this.repo.findAll();
	}

	// Find items by ID
	public ResponseEntity<Item> getItem(int id) {
		Optional<Item> found = this.repo.findById(id);
		// If the given ID is empty then returns status not found
		if (found.isEmpty()) {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		// If the given ID finds data then returns Item data
		Item body = found.get();
		return ResponseEntity.ok(body);
	}

	// Update items by ID
	public ResponseEntity<Item> updateItem(int id, Item itemDetails) {
		Optional<Item> found = this.repo.findById(id);
		// If the given ID is empty then returns status not found
		if (found.isEmpty()) {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		// If the given ID finds data then returns Item data
		Item exists = found.get();
		// If a field is not Null or 0 then set field input to XYZ
		if (itemDetails.getName() != null) {
			exists.setName(itemDetails.getName());
		}
		if (itemDetails.getDescription() != null) {
			exists.setDescription(itemDetails.getDescription());
		}
		if (itemDetails.getPrice() != 0) {
			exists.setPrice(itemDetails.getPrice());
		}
		if (itemDetails.getQuantity() != 0) {
			exists.setQuantity(itemDetails.getQuantity());
		}
		// saves new data inside the fields and returns new data
		Item updated = this.repo.save(exists);
		return ResponseEntity.ok(updated);
	}

	// Remove item by ID
	public boolean deleteItem(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
