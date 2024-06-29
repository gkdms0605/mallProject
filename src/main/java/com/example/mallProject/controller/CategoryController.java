package com.example.mallProject.controller;

import com.example.mallProject.domain.Category;
import com.example.mallProject.dto.CategoryAddDto;
import com.example.mallProject.dto.CategoryUpdateDto;
import com.example.mallProject.service.CategoryService;
import com.example.mallProject.dto.response.ResponseDataDto;
import com.example.mallProject.dto.response.ResponseListDataDto;
import com.example.mallProject.dto.response.ResponseMessageDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //카테고리 목록 조회 api
    @GetMapping("/list")
    public ResponseListDataDto<Category> getCategories(){
        return new ResponseListDataDto<>(
                HttpStatus.OK.toString(),
                "카테고리 목록 조회 성공",
                categoryService.getCategorys()
        );
    }

    //카테고리 상세 정보 조회 api
    @GetMapping("/{categoryId}")
    public ResponseDataDto<Category> getCategory(@PathVariable int categoryId){
        return new ResponseDataDto<>(
                HttpStatus.OK.toString(),
                "카테고리 정보 조회 성공",
                categoryService.getCategory(categoryId)
        );
    }

    //카테고리 생성 api
    @PostMapping("/add")
    public ResponseMessageDataDto addCategory(@RequestBody CategoryAddDto dto){
        return new ResponseMessageDataDto(
                HttpStatus.OK.toString(),
                categoryService.addCategory(dto)
        );
    }

    //카테고리 삭제 api
    @DeleteMapping("/delete/{categoryId}")
    public ResponseMessageDataDto deleteCategory(@PathVariable int categoryId){
        return new ResponseMessageDataDto(
                HttpStatus.OK.toString(),
                categoryService.deleteCategory(categoryId)
        );
    }

    //카테고리 수정 api
    @PutMapping("/update/{categoryId}")
    public ResponseMessageDataDto updateCategory(@PathVariable int categoryId, @RequestBody CategoryUpdateDto dto){

        return new ResponseMessageDataDto(
                HttpStatus.OK.toString(),
                categoryService.updateCategory(categoryId, dto)
        );
    }
}
