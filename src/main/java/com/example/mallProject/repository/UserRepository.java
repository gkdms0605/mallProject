package com.example.mallProject.repository;

import com.example.mallProject.domain.User;
import com.example.mallProject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
//    public Optional<UserEntity> findByEmail(String email);
//
//    @Modifying
//    @Query("UPDATE UserEntity ue " +
//            "SET ue.withdrawedYn = 'Y', ue.withdrawTime = :time " +
//            "WHERE ue.userIdx = :idx ")
//    void withdraw(@Param("idx") int idx, @Param("time") Date time);
}
