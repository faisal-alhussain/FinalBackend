package com.example.itemservices.controller.interfaces;


import com.example.itemservices.model.Item;

import java.util.List;

public interface IItemController {

    public List<Item> getAllItems();
    public List<Item> getCoursesByPriceLessThan(Integer price);


}