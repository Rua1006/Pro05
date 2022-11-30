package com.shop.service;


import com.shop.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> boardList() throws Exception;
}
