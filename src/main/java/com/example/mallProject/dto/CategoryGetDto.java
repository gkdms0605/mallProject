package com.example.mallProject.dto;

import com.example.mallProject.domain.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryGetDto {
    private String name;
    private List<Item> items = new ArrayList<>();
}
