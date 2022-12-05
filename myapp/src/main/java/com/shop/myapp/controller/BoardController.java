package com.shop.myapp.controller;


import com.shop.myapp.dto.BoardDTO;
import com.shop.myapp.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/board/")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("list")
    public String getBoardList(Model model) throws Exception{
        List<BoardDTO> boardList = boardService.boardList();
        model.addAttribute("boardList", boardList);
        return "/board/boardList";
    }
    @GetMapping("detail")
    public String getBoardList(@RequestParam("no") int no, Model model) throws Exception{
        BoardDTO dto = boardService.getBoard(no);
        model.addAttribute("dto", dto);
        return "/board/boardDetail";
    }
}
