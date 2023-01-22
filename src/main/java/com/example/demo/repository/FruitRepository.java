package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Fruit;

@Repository
public interface FruitRepository extends CrudRepository<Fruit, Integer> {
    // Custom methods can be added here
    List<Fruit> findByName(String name);
}