package com.example.mallProject.dto.response;

import com.example.mallProject.domain.Item;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
public class ResponsePageingDataDto {
    private String status;
    private String message;
    private Page<Item> page;
    private Pageable pageable;

    public ResponsePageingDataDto(String status, String message, Page<Item> page, Pageable pageable) {
        this.status = status;
        this.message = message;
        this.page = page;
        this.pageable = pageable;
    }
}
