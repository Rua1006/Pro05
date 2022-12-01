package com.shop.myapp.service;

import com.shop.myapp.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> boardList() throws Exception;
}
