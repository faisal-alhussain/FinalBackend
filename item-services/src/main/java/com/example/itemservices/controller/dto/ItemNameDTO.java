package com.example.itemservices.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemNameDTO {

    public String getName() {
        return name;
    }

    private String name;
}
