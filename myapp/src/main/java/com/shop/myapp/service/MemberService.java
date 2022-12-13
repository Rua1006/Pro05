package com.shop.myapp.service;

import com.shop.myapp.dto.MemberDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MemberService {
    public List<MemberDTO> memberList() throws Exception;
    public MemberDTO getMember(String id) throws Exception;
    public void memberInsert(MemberDTO dto) throws Exception;
    public MemberDTO signIn(MemberDTO mdto) throws Exception;
    public MemberDTO loginCheck(MemberDTO mdto) throws Exception;
<<<<<<< HEAD
=======
    public boolean login(HttpServletRequest request) throws Exception;
>>>>>>> 9174528b32d015711b6f045e1a44f86a13fd6909
    public void memberUpdate(MemberDTO mdto) throws Exception;
    public void memberDelete(String id) throws Exception;
}
