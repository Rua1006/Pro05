package com.shop.myapp.dao;

import com.shop.myapp.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDAOImpl implements MemberDAO{

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<MemberDTO> memberList() throws Exception {
        return sqlSession.selectList("member.memberList");
    }

    @Override
    public MemberDTO getMember(String id) throws Exception {
        return sqlSession.selectOne("member.getMember", id);
    }

    @Override
    public void memberInsert(MemberDTO dto) throws Exception {
        sqlSession.insert("member.memberInsert", dto);
    }

    @Override
    public MemberDTO signIn(MemberDTO mdto) throws Exception {
        return sqlSession.selectOne("member.signIn", mdto);
    }

    @Override
    public MemberDTO loginCheck(MemberDTO mdto) throws Exception {
        mdto = sqlSession.selectOne("member.loginCheck", mdto);
        return mdto;
    }

    @Override
    public void memberUpdate(MemberDTO mdto) throws Exception {
        sqlSession.update("member.memberUpdate", mdto);
    }

    @Override
    public void memberDelete(String id) throws Exception {
        sqlSession.delete("member.memberDelete", id);
    }
}