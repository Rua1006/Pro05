package com.shop.service;

import com.shop.dao.BoardDAO;
import com.shop.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardDAO boardDAO;

    @Override
    public List<BoardDTO> boardList() throws Exception {
        return boardDAO.boardList();
    }
}
