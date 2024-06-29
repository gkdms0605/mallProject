package com.example.mallProject.service;

import com.example.mallProject.domain.Item;
import com.example.mallProject.domain.User;
import com.example.mallProject.repository.ItemRepository;
import com.example.mallProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;


    //사용자 ID에 따른 위시리스트 조회
    public List<Item> getUserWishlist(String userId){
        User user = userRepository.findById(userId).orElse(null);
        if (user != null){
            return user.getWishlist();
        }
        else {
            return new ArrayList<>();
        }
    }

    //위시리스트 아이템 추가
    public String addItemToWishlist(String userId, int itemId){
        User user  = userRepository.findById(userId).orElse(null);
        if(user == null){
            throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
        }

        Item item = itemRepository.findById(itemId).orElse(null);
        if(item == null){
            throw new IllegalArgumentException("존재하지 않는 상품입니다.");
        }

        user.addToWishlist(item);
        userRepository.save(user);

        return "위시리스트에 상품 추가가 완료되었습니다.";
    }

    //위시리스트 아이템 삭제
    public String deleteItemFromWishlist(String userId, int itemId){
        User user  = userRepository.findById(userId).orElse(null);
        if(user == null){
            throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
        }

        Item item = itemRepository.findById(itemId).orElse(null);
        if(item == null){
            throw new IllegalArgumentException("존재하지 않는 상품입니다.");
        }

        user.deleteFromWishlist(item);
        userRepository.save(user);

        return "위시리스트에서 상품 삭제가 완료되었습니다.";
    }
}
