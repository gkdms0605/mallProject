package com.example.mallProject.domain;

import com.example.mallProject.domain.Item;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 자동 증가
    private int id;

    private String name;

    @OneToMany(mappedBy = "category") //일 대 다 관계 지정
    private List<Item> items = new ArrayList<>();
}
