package com.example.mallProject.service;

import com.example.mallProject.domain.Category;
import com.example.mallProject.repository.CategoryRepository;
import com.example.mallProject.domain.Item;
import com.example.mallProject.dto.ItemAddDto;
import com.example.mallProject.dto.ItemUpdateDto;
import com.example.mallProject.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    // 카테고리 별 아이템 조회
    public List<Item> getCategoryItem(int category) {
        Category findCategory = categoryRepository.findById(category).orElse(null);
        if(findCategory == null){
            throw new IllegalArgumentException("카테고리가 존재하지 않습니다.");
        }

        List<Item> items = itemRepository.findAllByCategoryId(category);
        items.sort(Comparator.comparing(Item::getAddDate).reversed());
        return items;
    }

    //물품 전체 조회 (최신 등록순)
    public org.springframework.data.domain.Page<Item> getItems(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("addDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.itemRepository.findAll(pageable);
    }

    // 물품 조회
    public Item getItem(int ItemId){
        Item item = itemRepository.findById(ItemId).orElse(null);
        if(item == null){
            throw new IllegalArgumentException("상품이 존재하지 않습니다.");
        }

        return item;
    }


    // 물품 추가
    public Item addItem(ItemAddDto dto){
        Category category = categoryRepository.findById(dto.getCategoryId()).orElse(null);
        if(category == null){
            throw new IllegalArgumentException("해당하는 카테고리가 존제하지 않습니다.");
        }

        Item item = new Item(
                dto.getItemName(),
                dto.getItemDetail(),
                dto.getStockNum(),
                dto.getPrice(),
                category
        );

        return itemRepository.save(item);
    }


    //물품 정보 수정
    @Transactional
    public Item updateItem(int itemId, ItemUpdateDto dto){

        Item item = itemRepository.findById(itemId).orElse(null);
        if(item == null){
            throw new IllegalArgumentException("상품이 존재하지 않습니다.");
        }

        Category category = categoryRepository.findById(dto.getCategoryId()).orElse(null);
        if(category == null){
            throw new IllegalArgumentException("카테고리가 존재하지 않습니다.");
        }

        item.setItemName(dto.getItemName());
        item.setItemDetail(dto.getItemDetail());
        item.setPrice(dto.getPrice());
        item.setStockNum(dto.getStockNum());
        item.setCategory(category);

        return itemRepository.save(item);
    }

   //  물품 정보 삭제
     public String deleteItem(int itemId){
        Item item = itemRepository.findById((itemId)).orElse(null);
        if(item == null){
            throw new IllegalArgumentException("삭제할 상품이 존재하지 않습니다.");
        }

        itemRepository.deleteById(itemId);
        return "상품 삭제가 완료되었습니다.";
     }
}
