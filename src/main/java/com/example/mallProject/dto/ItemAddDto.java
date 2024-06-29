package com.example.mallProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemAddDto {
    private String itemName;
    private String itemDetail;
    private int stockNum;
    private int price;
    private int categoryId;
}

