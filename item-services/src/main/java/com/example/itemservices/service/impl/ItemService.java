package com.example.itemservices.service.impl;


import com.example.itemservices.model.Item;
import com.example.itemservices.repository.ItemRepository;
import com.example.itemservices.service.interfaces.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements IItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item getItemById(String item) {
        Optional<Item> itemOptional = itemRepository.findById(item);
        return itemOptional.orElse(null);
    }
    @Override
    public List<Item> getCourseByPriceAndName(String name, Optional<Integer> price) {
        if (price.isPresent()) return itemRepository.findAllByNameAndPrice(name, price.get());
        return itemRepository.findAllByName(name);
    }

    @Override
    public void updateItem(Item product, String id) {
        Optional<Item> productOptional = itemRepository.findById(id);
        if (productOptional.isEmpty()) return;
        product.setProduct(id);
        itemRepository.save(product);
    }

    @Override
    public void updateItemPrice(Integer price, String id) {
        Optional<Item> productOptional = itemRepository.findById(id);
        if (productOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"item not found");
        Item product = productOptional.get();
        product.setPrice(price);
        itemRepository.save(product);
    }

    @Override
    public void updateItemName(String name, String id) {
        Optional<Item> productOptional = itemRepository.findById(id);
        if (productOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"item not found");
        Item product = productOptional.get();
        product.setName(name);
        itemRepository.save(product);
    }

    @Override
    public void deleteItem(String id) {
        Optional<Item> productOptional = itemRepository.findById(id);
        if (productOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"item not found");
        itemRepository.deleteById(id);
    }
}
