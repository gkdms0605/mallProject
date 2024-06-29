package com.example.mallProject.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ResponseListDataDto<Data> {
    private String status;
    private String message;
    private final List<Data> data;

    public ResponseListDataDto(String status, String message, List<Data> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
