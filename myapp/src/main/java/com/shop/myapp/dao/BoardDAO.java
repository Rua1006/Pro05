package com.shop.myapp.dao;

import com.shop.myapp.dto.BoardDTO;

import java.util.List;

public interface BoardDAO {
    public List<BoardDTO> boardList() throws Exception;
}
