package com.Inc.Project1.BE.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Inc.Project1.BE.domain.Basket;
import com.Inc.Project1.BE.domain.Item;
import com.Inc.Project1.BE.repo.BasketRepo;
import com.Inc.Project1.BE.repo.ItemRepo;

@Service
public class ItemServices {
	private ItemRepo repo;
	private BasketRepo basketRepo;

	public ItemServices(ItemRepo repo, BasketRepo basketRepo) {
		super();
		this.repo = repo;
		this.basketRepo = basketRepo;
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
		if (itemDetails.getPrice() != 0) {
			exists.setPrice(itemDetails.getPrice());
		}

		if (itemDetails.getBasket() != null) {
			exists.setBasket(itemDetails.getBasket());
		}
		// saves new data inside the fields and returns new data
		Item updated = this.repo.save(exists);
		return ResponseEntity.ok(updated);
	}

	// Add item to basket
	public ResponseEntity<Object> addToBasket(int itemId, int basketId) {
		Optional<Item> toAddToBasket = this.repo.findById(itemId);

		if (toAddToBasket.isEmpty()) {
			return new ResponseEntity<Object>("This item doesn't exist", HttpStatus.NOT_FOUND);
		}

		Item exists = toAddToBasket.get();

		if (exists.getBasket() != null) {
			return new ResponseEntity<Object>("Item is out of stock", HttpStatus.BAD_REQUEST);
		}

		Optional<Basket> customer = this.basketRepo.findById(basketId);

		if (customer.isEmpty()) {
			return new ResponseEntity<Object>("Basket with this ID does not exist", HttpStatus.BAD_REQUEST);
		}

		exists.setBasket(customer.get());

		Item updated = this.repo.save(exists);
		return ResponseEntity.ok(updated);

	}

	// Remove item from basket
	public ResponseEntity<Object> removeFromBasket(int itemId) {
		Optional<Item> toRemoveFromBasket = this.repo.findById(itemId);
		if (toRemoveFromBasket.isEmpty()) {
			return new ResponseEntity<Object>("This item doesn' exist", HttpStatus.NOT_FOUND);
		}

		Item exists = toRemoveFromBasket.get();
		exists.setBasket(null);
		Item addedItem = this.repo.save(exists);
		return ResponseEntity.ok(addedItem);

	}

	// Remove item by ID
	public boolean deleteItem(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
