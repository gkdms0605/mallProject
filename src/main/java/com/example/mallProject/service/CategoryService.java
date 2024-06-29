package com.example.mallProject.service;

import com.example.mallProject.domain.Category;
import com.example.mallProject.dto.CategoryAddDto;
import com.example.mallProject.dto.CategoryUpdateDto;
import com.example.mallProject.repository.CategoryRepository;
import com.example.mallProject.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    //카테고리 전체 조회
    public List<Category> getCategorys(){
        return categoryRepository.findAll();
    }

    //카테고리 추가
    public String addCategory(CategoryAddDto dto){
        Category newCategory = new Category();
        newCategory.setName(dto.getName());
        categoryRepository.save(newCategory);
        return "카테고리 추가가 완료되었습니다.";
    }

    //카테고리 조회
    public Category getCategory(int categoryId){
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if(category == null){
            throw new IllegalArgumentException("존재하지 않는 카테고리입니다.");
        }
        return category;
    }

    //카테고리 업데이트
    @Transactional
    public String updateCategory(int id, CategoryUpdateDto dto){
        Category category = categoryRepository.findById(id).orElse(null);
        if(category == null){
            throw new IllegalArgumentException("존재하지 않는 카테고리입니다.");
        }

        category.setName(dto.getName());
        category.setItems(dto.getItems());

        return "카테고리 정보 수정이 완료되었습니다.";
    }

    //카테고리 삭제
    public String deleteCategory(int id){
        Category category = categoryRepository.findById(id).orElse(null);
        if(category == null){
            throw new IllegalArgumentException("존재하지 않는 카테고리입니다.");
        }

        categoryRepository.deleteById(id);

        return "카테고리 삭제가 완료되었습니다.";
    }
}
