package com.Inc.Project1.BE.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inc.Project1.BE.domain.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
