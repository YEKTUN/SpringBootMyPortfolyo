package com.porffolyo.MyPortfolyo.service;

import com.porffolyo.MyPortfolyo.RootEntity;
import com.porffolyo.MyPortfolyo.dto.DtoInfo;
import com.porffolyo.MyPortfolyo.model.Info;
import com.porffolyo.MyPortfolyo.repository.InfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Autowired
    InfoRepository infoRepo;


    public RootEntity<DtoInfo> createUserInfo(Info user) {
        DtoInfo dtoInfo = new DtoInfo();

        if (emailExists(user.getEmail())) {
            return RootEntity.error("Email already exists");
        }

        Info savedUser = infoRepo.save(user);
        BeanUtils.copyProperties(savedUser, dtoInfo);
        return RootEntity.ok(dtoInfo);
    }


    public boolean emailExists(String email) {
        return infoRepo.findByEmail(email).isPresent();
    }

}
