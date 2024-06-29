package com.example.mallProject.repository;

import com.example.mallProject.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findAllByCategoryId(int category);
    Page<Item> findAll(Pageable pageable);
}
