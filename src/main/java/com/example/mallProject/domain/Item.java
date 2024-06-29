package com.example.mallProject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    private String itemName;
    private String itemDetail;
    private int stockNum;
    private int price;

    @CreatedDate
    Date addDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_list")
    @JsonIgnore
    private Category category;

    @ManyToMany(mappedBy = "wishlist")
    @JsonIgnore
    private List<User> users;

    public Item(String itemName, String itemDetail, int stockNum, int price, Category category){
        this.itemName = itemName;
        this.itemDetail = itemDetail;
        this.stockNum = stockNum;
        this.price = price;
        this.category = category;
    }
}
