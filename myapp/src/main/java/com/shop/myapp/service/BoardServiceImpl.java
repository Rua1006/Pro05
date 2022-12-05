package com.shop.myapp.service;

import com.shop.myapp.dao.BoardDAO;
import com.shop.myapp.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardDAO boardDAO;

    @Override
    public List<BoardDTO> boardList() throws Exception {
        return boardDAO.boardList();
    }

    @Override
    public BoardDTO getBoard(int no) throws Exception {
        return boardDAO.getBoard(no);
    }
}
