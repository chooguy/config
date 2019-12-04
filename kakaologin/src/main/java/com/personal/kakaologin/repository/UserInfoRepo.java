package com.personal.kakaologin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.kakaologin.domain.model.entity.UserInfo;

public interface UserInfoRepo extends JpaRepository <UserInfo, String> {

}