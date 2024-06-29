package com.example.mallProject.dto;

import com.example.mallProject.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemGetDto {
    private Long itemId;
    private String itemName;
    private String itemDetail;
    private int stockNum;
    private int price;
    private List<Category> categories;

    //    private String imgNum;
}
