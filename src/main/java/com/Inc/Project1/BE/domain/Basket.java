package com.Inc.Project1.BE.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Basket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
//	@Column(nullable = false)
	private String name;
//	@Column(nullable = false)
//	private Double price;
//	@Column(nullable = false)
//	private Double quantity;

	@JsonManagedReference(value = "for-item")
	@OneToMany(mappedBy = "basket")
	private List<Item> items;

	public Basket() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}