package com.shop.controller;

import com.shop.dto.BoardDTO;
import com.shop.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/content/*")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/boardList")
    public String getBoardList(Model model) throws Exception {
        List<BoardDTO> boardList = boardService.boardList();
        model.addAttribute("boardList", boardList);
        return "board/boardList";
    }


}
