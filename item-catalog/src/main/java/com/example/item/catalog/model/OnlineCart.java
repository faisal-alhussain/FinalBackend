package com.example.item.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@PrimaryKeyJoinColumn(name = "id")
public class OnlineCart extends ShoppingCart {

    private Integer ShippingAddress;

    public ShoppingCart getCustomer() {
        return customer;
    }

    public void setCustomer(ShoppingCart customer) {
        this.customer = customer;
    }

    @OneToOne
    private ShoppingCart customer;


}