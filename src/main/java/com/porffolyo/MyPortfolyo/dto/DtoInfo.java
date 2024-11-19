package com.porffolyo.MyPortfolyo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoInfo {
    private String name;
    private String email;
    private String message;
}
