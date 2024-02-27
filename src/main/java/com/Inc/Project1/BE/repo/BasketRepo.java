package com.Inc.Project1.BE.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inc.Project1.BE.domain.Basket;

public interface BasketRepo extends JpaRepository<Basket, Integer> {

}