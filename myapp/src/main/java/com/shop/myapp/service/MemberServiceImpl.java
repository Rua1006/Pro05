package com.shop.myapp.service;

import com.shop.myapp.dao.MemberDAO;
import com.shop.myapp.dto.MemberDTO;

import org.springframework.beans.factory.annotation.Autowired;

<<<<<<< HEAD
=======
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
>>>>>>> 9174528b32d015711b6f045e1a44f86a13fd6909
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberDAO memberDao;

<<<<<<< HEAD

=======
    @Inject
    BCryptPasswordEncoder pwdEncoder;
>>>>>>> 9174528b32d015711b6f045e1a44f86a13fd6909

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

<<<<<<< HEAD
=======
    //서비스에서 로그인 처리
    @Override
    public boolean login(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        boolean loginSuccess = false;
        MemberDTO mdto = new MemberDTO();

        mdto.setId(request.getParameter("id"));
        mdto.setPw(request.getParameter("pw"));

        MemberDTO login = memberDao.login(mdto);

        loginSuccess =  pwdEncoder.matches(mdto.getPw(), login.getPw());
        if(login != null && loginSuccess==true) {
            session.setAttribute("member", login);
            session.setAttribute("sid", login.getId());
            loginSuccess = true;
        }
        return loginSuccess;
    }
>>>>>>> 9174528b32d015711b6f045e1a44f86a13fd6909

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