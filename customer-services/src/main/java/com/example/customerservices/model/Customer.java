package com.example.customerservices.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @jakarta.persistence.Id
    private Integer id;

    private String customer;

}