package com.shop.myapp.service;

import com.shop.myapp.dao.MemberDAO;
import com.shop.myapp.dto.MemberDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberDAO memberDao;



    @Override
    public List<MemberDTO> memberList() throws Exception {
        return memberDao.memberList();
    }

    @Override
    public MemberDTO getMember(String id) throws Exception {
        return memberDao.getMember(id);
    }

    @Override
    public void memberInsert(MemberDTO dto) throws Exception {
        memberDao.memberInsert(dto);
    }

    //컨트롤러에서 로그인 처리
    @Override
    public MemberDTO signIn(MemberDTO mdto) throws Exception {
        return memberDao.signIn(mdto);
    }


    @Override
    public MemberDTO loginCheck(MemberDTO mdto) throws Exception {
        return memberDao.loginCheck(mdto);
    }

    @Override
    public void memberUpdate(MemberDTO mdto) throws Exception {
        memberDao.memberUpdate(mdto);
    }

    @Override
    public void memberDelete(String id) throws Exception {
        memberDao.memberDelete(id);
    }


}