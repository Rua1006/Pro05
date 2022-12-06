package com.shop.myapp.dao;

import com.shop.myapp.dto.MemberDTO;

import java.util.List;

public interface MemberDAO {
    public List<MemberDTO> memberList() throws Exception;
    public MemberDTO getMember(String id) throws Exception;
    public void memberInsert(MemberDTO dto) throws Exception;
    public MemberDTO signIn(MemberDTO mdto) throws Exception;
    public MemberDTO loginCheck(MemberDTO mdto) throws Exception;
    public void memberUpdate(MemberDTO mdto) throws Exception;
    public void memberDelete(String id) throws Exception;
}
