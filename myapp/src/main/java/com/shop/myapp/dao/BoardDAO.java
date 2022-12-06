package com.shop.myapp.dao;

import com.shop.myapp.dto.BoardDTO;

import java.util.List;

public interface BoardDAO {
    public List<BoardDTO> boardList() throws Exception;
    public BoardDTO getBoard(int no) throws Exception;
    public void boardInsert(BoardDTO dto) throws Exception;
    public void boardDelete(int no) throws Exception;
    public void boardEdit(BoardDTO dto) throws Exception;
}
