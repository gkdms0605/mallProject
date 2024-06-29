package com.example.mallProject.controller;

import com.example.mallProject.domain.User;
import com.example.mallProject.dto.UserAddDto;
import com.example.mallProject.dto.UserUpdateDto;
import com.example.mallProject.dto.response.ResponseDataDto;
import com.example.mallProject.dto.response.ResponseMessageDataDto;
import com.example.mallProject.service.UserService;
import com.example.mallProject.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private WishlistService wishlistService;

    // 사용자 조회 api
    @GetMapping("/{userId}")
    public ResponseDataDto<User> getUser(@PathVariable String userId){
        return new ResponseDataDto<>(
                HttpStatus.OK.toString(),
                "message",
                userService.getUser(userId)
        );
    }

    // 사용자 추가 api
    @PostMapping("/add")
    public ResponseMessageDataDto addUser(@RequestBody UserAddDto dto){
        userService.addUser(dto);
        return new ResponseMessageDataDto(
                HttpStatus.OK.toString(),
                "사용자 추가가 완료되었습니다."
        );
    }

    // 사용자 업데이트 api
    @PutMapping("/update/{userId}")
    public ResponseMessageDataDto update(@PathVariable String userId, @RequestBody UserUpdateDto dto){
        return new ResponseMessageDataDto(
                HttpStatus.OK.toString(),
                userService.updateUser(userId, dto)
        );
    }

    // 사용자 삭제 api
    @DeleteMapping("/delete/{userId}")
    public ResponseMessageDataDto delete(@PathVariable String userId){
        return new ResponseMessageDataDto(
                HttpStatus.OK.toString(),
                userService.deleteUser(userId)
        );
    }

}
