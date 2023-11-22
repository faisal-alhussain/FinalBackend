package com.example.itemservices.controller.impl;


import com.example.itemservices.controller.dto.ItemNameDTO;
import com.example.itemservices.controller.dto.ItemPriceDTO;
import com.example.itemservices.controller.interfaces.IItemController;
import com.example.itemservices.model.Item;
import com.example.itemservices.repository.ItemRepository;
import com.example.itemservices.service.interfaces.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItemController implements IItemController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    IItemService iItemService;

    @GetMapping("/item")
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/item/price")
    public List<Item> getCoursesByPriceLessThan(@RequestParam(defaultValue = "800") Integer price) {
        return itemRepository.findAllByPriceLessThan(price);
    }
    @GetMapping("/item/name")
    public List<Item> getCourseByNameAndPrice(
            @RequestParam(defaultValue = "superman") String name,
            @RequestParam Optional<Integer> price
    )
    {
        if (price.isPresent()) return itemRepository.findAllByNameAndPrice(name, price.get());
        return itemRepository.findAllByName(name);
    }
    //  ***************************************************  POST  ****************************************************

    @PostMapping("/item")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveItem(@RequestBody Item product) {
        itemRepository.save(product);
    }

    //  ****************************************************  PUT  ****************************************************

    @PutMapping("/item/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItem(@RequestBody Item product, @PathVariable String id) {
        iItemService.updateItem(product, id);
    }
    //  ***************************************************  PATCH  ***************************************************

    @PatchMapping("/item/price/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItemPrice(@RequestBody ItemPriceDTO itemPriceDTO, @PathVariable String id) {
        iItemService.updateItemPrice(itemPriceDTO.getPrice(), id);
    }

    @PatchMapping("/item/name/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItemName(@RequestBody ItemNameDTO itemNameDTO, @PathVariable String id) {
        iItemService.updateItemName(itemNameDTO.getName(), id);
    }
    //  **************************************************  DELETE  ***************************************************

    @DeleteMapping("/item/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable String id) {
        iItemService.deleteItem(id);
    }}