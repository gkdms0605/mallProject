package com.example.mallProject.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMessageDataDto {
    private String status;
    private String message;

    public ResponseMessageDataDto(String state, String message){
        this.status = state;
        this.message = message;
    }
}
