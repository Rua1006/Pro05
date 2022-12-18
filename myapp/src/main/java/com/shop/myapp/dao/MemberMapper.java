package com.shop.myapp.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shop.myapp.dto.MemberDTO;

@Mapper
public interface MemberMapper {
    // 로그인
    MemberDTO getUserAccount(String userId);

    // 회원가입
    void saveUser(MemberDTO memberDTO);

    // 회원정보 수정
    void updateUser(MemberDTO memberDTO);
}
