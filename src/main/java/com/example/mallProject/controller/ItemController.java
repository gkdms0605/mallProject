package com.example.mallProject.controller;

import com.example.mallProject.domain.Item;
import com.example.mallProject.dto.ItemAddDto;
import com.example.mallProject.dto.ItemUpdateDto;
import com.example.mallProject.dto.response.ResponseDataDto;
import com.example.mallProject.dto.response.ResponseListDataDto;
import com.example.mallProject.dto.response.ResponseMessageDataDto;
import com.example.mallProject.dto.response.ResponsePageingDataDto;
import com.example.mallProject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // 카테고리별 물품 조회 (성공)
    @GetMapping("/category/{categoryId}")
    public ResponseListDataDto<Item> getCategoryItem(@PathVariable int categoryId){
        return new ResponseListDataDto<>(
                HttpStatus.OK.toString(),
                "조회 성공",
                itemService.getCategoryItem(categoryId)
        );
    }

    //전체 조회 (성공)
    @GetMapping
    public ResponsePageingDataDto items(@RequestParam(value = "page", defaultValue = "0") int page){
        Page<Item> pagingResult = this.itemService.getItems(page);
        Pageable pageable = pagingResult.getPageable();
        return new ResponsePageingDataDto(
                HttpStatus.OK.toString(),
                "불러오기 성공",
                pagingResult,
                pageable
        );
    }

    //물품 상세 조회 (성공)
    @GetMapping("/{itemId}")
    public ResponseDataDto<Item> getItem(@PathVariable int itemId){
        return new ResponseDataDto<>(
                HttpStatus.OK.toString(),
                "message",
                itemService.getItem(itemId)
        );
    }

    //물품 추가 (성공)
    @PostMapping("/add")
    public ResponseDataDto<Item> add(@RequestBody ItemAddDto dto) {
        return new ResponseDataDto(HttpStatus.OK.toString(), "물품 추가가 완료되었습니다.", itemService.addItem(dto));
    }


    //물품 정보 업데이트 -> 업데이트 후 카테고리에서 데이터 실종
    @PutMapping("/update/{itemId}")
    public ResponseDataDto<Item> update(@PathVariable int itemId, @RequestBody ItemUpdateDto dto){
        return new ResponseDataDto<>(
                HttpStatus.OK.toString(),
                "업데이트가 완료되었습니다.",
                itemService.updateItem(itemId,dto)
                );
    }

    //물품 정보 삭제 (성공)
    @DeleteMapping("/delete/{itemId}")
    public ResponseMessageDataDto delete(@PathVariable int itemId){
        itemService.deleteItem(itemId);
        return new ResponseMessageDataDto(
                HttpStatus.OK.toString(),
                "업데이트가 완료되었습니다."
        );
    }
}
