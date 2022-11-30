package com.shop.dao;

import com.shop.dto.BoardDTO;

import java.util.List;

public interface BoardDAO {
    public List<BoardDTO> boardList() throws Exception;

}
