package com.porffolyo.MyPortfolyo.exception;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class ErrorResponse {
    private String id;
    private Date errorTime;
    private Map<String, List<String>> errorMessage;
}
