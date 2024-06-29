package com.example.mallProject.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDataDto<Data> {
    private String status;
    private String message;
    private Data data;

    public ResponseDataDto(String status, String message, Data data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

}
