package com.example.item.catalog.controller;

import com.example.item.catalog.model.Catalog;
import com.example.item.catalog.model.Customer;
import com.example.item.catalog.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class CatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/catalogs/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Catalog getCatalog(@PathVariable int id) {
        try {
            Customer customer = restTemplate.getForObject("http://customer-services/api/customer/" + id, Customer.class);
            Item item = restTemplate.getForObject("http://item-services/api/item", Item.class);

            Catalog catalog = new Catalog();
            catalog.setCustomerName(customer.getCustomer());
            catalog.setItem(item);

            return catalog;
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            throw new RuntimeException("Internal Server Error");
        }
    }
}