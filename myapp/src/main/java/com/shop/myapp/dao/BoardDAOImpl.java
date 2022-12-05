package com.shop.myapp.dao;

import com.shop.myapp.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO{

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<BoardDTO> boardList() throws Exception {
        return sqlSession.selectList("board.boardList");
    }

    @Override
    public BoardDTO getBoard(int no) throws Exception {
        return sqlSession.selectOne("board.getBoard", no);
    }
}
