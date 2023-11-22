package com.example.itemservices.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPriceDTO {


    public Integer getPrice() {
        return price;
    }

    private Integer price;

}
