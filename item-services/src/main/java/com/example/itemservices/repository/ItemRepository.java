package com.example.itemservices.repository;

import com.example.itemservices.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, String> {

    List<Item> findAllByPriceLessThan(Integer price);
    List<Item> findAllByName(String name);
    List<Item> findAllByNameAndPrice(String name, Integer Price);

}

