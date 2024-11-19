package com.porffolyo.MyPortfolyo.controller;

import com.porffolyo.MyPortfolyo.RootEntity;

public class BaseController {

    public <T> RootEntity<T> ok(T data) {
        return RootEntity.ok(data);
    }

    public <T> RootEntity<T> error(String errorMessage) {
        return RootEntity.error(errorMessage);
    }
}
