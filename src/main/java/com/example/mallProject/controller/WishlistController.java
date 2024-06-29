package com.example.mallProject.controller;

import com.example.mallProject.domain.Item;
import com.example.mallProject.dto.response.ResponseListDataDto;
import com.example.mallProject.dto.response.ResponseMessageDataDto;
import com.example.mallProject.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/wishlist/")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    //userId에 따른 위시리스트 아이템 조회
    @GetMapping("{userId}")
    public ResponseListDataDto<Item> getWishlistItems(@PathVariable String userId){
        return new ResponseListDataDto<>(
                HttpStatus.OK.toString(),
                "message",
                wishlistService.getUserWishlist(userId)
        );
    }

    //위시리스트 아이템 추가
    @PostMapping("{userId}/add/{itemId}")
    public ResponseMessageDataDto addToWishlistItems(@PathVariable String userId, @PathVariable int itemId){
        return new ResponseMessageDataDto(
                HttpStatus.OK.toString(),
                wishlistService.addItemToWishlist(userId, itemId)
        );
    }


    //위시리스트 아이템 삭제
    @DeleteMapping("{userId}/delete/{itemId}")
    public ResponseMessageDataDto deleteFromWishlistItems(@PathVariable String userId, @PathVariable int itemId){
        return new ResponseMessageDataDto(
                HttpStatus.OK.toString(),
                wishlistService.deleteItemFromWishlist(userId, itemId)
        );
    }

}
