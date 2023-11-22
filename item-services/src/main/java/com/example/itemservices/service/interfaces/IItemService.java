package com.example.itemservices.service.interfaces;

import com.example.itemservices.model.Item;

import java.util.List;
import java.util.Optional;

public interface IItemService {
    Item getItemById(String item);

    List<Item> getCourseByPriceAndName(String name, Optional<Integer> price);

    void updateItem(Item product, String id);

    void updateItemPrice(Integer price, String id);

    void updateItemName(String name, String id);

    void deleteItem(String id);
}
