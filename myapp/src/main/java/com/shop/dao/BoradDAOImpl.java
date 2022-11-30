package com.shop.dao;

import com.shop.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoradDAOImpl implements BoardDAO {

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<BoardDTO> boardList() throws Exception {
        return sqlSession.selectList("board.boardList");
    }
}
