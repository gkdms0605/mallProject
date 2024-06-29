package com.example.mallProject.domain;

import com.example.mallProject.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    private String password;
    private String name;
    private String userNm;

//    @Column(insertable = false)
//    private int grade;
//
//    @Column(updatable = false)
//    private Date registerTime;
//
//    private Date lastLoginTime;
//
//    @Column(insertable = false)
//    private String withdrawedYn;
//
//    private Date withdrawTime;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_wishlist",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    @Builder.Default
    private List<Item> wishlist = new ArrayList<>();

    public User(String userId, String password, String name, String userNm){
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.userNm = userNm;
//        this.grade = grade;
    }

    public void addToWishlist(Item item){
        wishlist.add(item);
    }

    public void deleteFromWishlist(Item item){
        wishlist.remove(item);
    }

//    public static UserEntity toEntity(User domain) {
//        return UserEntity.builder()
//                .userIdx(domain.getUserIdx())
//                .email(domain.getEmail())
//                .name(domain.getName())
//                .password(domain.getPassword())
//                .grade(domain.getGrade())
//                .registerTime(domain.getRegisterTime())
//                .lastLoginTime(domain.getLastLoginTime())
//                .withdrawedYn(domain.getWithdrawedYn())
//                .withdrawTime(domain.getWithdrawTime())
//                .build();
//    }

//    public static User toDomain(UserEntity entity) {
//        return User.builder()
//                .userIdx(entity.getUserIdx())
//                .email(entity.getEmail())
//                .name(entity.getName())
//                .password(entity.getPassword())
//                .grade(entity.getGrade())
//                .registerTime(entity.getRegisterTime())
//                .lastLoginTime(entity.getLastLoginTime())
//                .withdrawedYn(entity.getWithdrawedYn())
//                .withdrawTime(entity.getWithdrawTime())
//                .build();
//
//    }
}
