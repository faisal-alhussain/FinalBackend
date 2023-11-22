package com.example.itemservices.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    private String product;

    private String name;
    private Integer price;
    private Integer quantity;

    @ManyToOne
    @JoinTable(
            name = "courses_grades",
            joinColumns = @JoinColumn(name = "item_code"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Customer customer;
}
