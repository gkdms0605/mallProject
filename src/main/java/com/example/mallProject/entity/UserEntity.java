package com.example.mallProject.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class UserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userIdx;

    private String email;

    private String name;

    private String password;

    @Column(insertable = false)
    private int grade;

    @Column(updatable = false)
    private Date registerTime;

    private Date lastLoginTime;

    @Column(insertable = false)
    private String withdrawedYn;

    private Date withdrawTime;

}
