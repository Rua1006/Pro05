package com.shop.myapp.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.myapp.dao.MemberMapper;
import com.shop.myapp.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService{
    SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

    private final MemberMapper memberMapper;

    @Transactional
    public void joinUser(MemberDTO memberDTO){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDTO.setUserPw(passwordEncoder.encode(memberDTO.getPassword()));
        memberDTO.setUserAuth("USER");
        memberDTO.setAppendDate(localTime);
        memberDTO.setUpdateDate(localTime);
        memberMapper.saveUser(memberDTO);
    }

    @Override
    public MemberDTO loadUserByUsername(String userId) throws UsernameNotFoundException {
        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
        MemberDTO memberDTO = memberMapper.getUserAccount(userId);
        if (memberDTO == null){
            throw new UsernameNotFoundException("User not authorized.");
        }
        return memberDTO;
    }

    public MemberDTO getUserAccount(String userId) {
        MemberDTO memberDTO = memberMapper.getUserAccount(userId);
        return memberDTO;
    }

    public void updateUser(MemberDTO member) {
        memberMapper.updateUser(member);
    }
}
