package com.porffolyo.MyPortfolyo.repository;

import com.porffolyo.MyPortfolyo.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {


    Optional<Info> findByEmail(String email);
}
