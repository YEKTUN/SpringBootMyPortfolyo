package com.porffolyo.MyPortfolyo.controller;

import com.porffolyo.MyPortfolyo.RootEntity;
import com.porffolyo.MyPortfolyo.dto.DtoInfo;
import com.porffolyo.MyPortfolyo.model.Info;
import com.porffolyo.MyPortfolyo.service.InfoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InfoController extends BaseController {
    @Autowired
    InfoService infoService;

    @PostMapping("/createUserInfo")
    public RootEntity<DtoInfo> createUserInfo(@Valid @RequestBody Info info) {


        return infoService.createUserInfo(info);


    }
}
