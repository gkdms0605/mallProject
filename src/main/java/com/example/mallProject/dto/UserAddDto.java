package com.example.mallProject.dto;

import com.example.mallProject.domain.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserAddDto {
    private String userId;
    private String password;
    private String name;
    private String userNm;
//    private int grade;
    private List<Item> wishlist;
}
