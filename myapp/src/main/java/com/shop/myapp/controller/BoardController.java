package com.shop.myapp.controller;


import com.shop.myapp.dto.BoardDTO;
import com.shop.myapp.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/")
public class BoardController {


    private final BoardService boardService;

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
    @GetMapping("insert")
    public String insertForm(HttpServletRequest request, Model model) throws Exception{
        return "/board/boardInsert";
    }
    @PostMapping("insert")
    public String boardInsert(HttpServletRequest request, Model model) throws Exception{
        BoardDTO dto = new BoardDTO();
        dto.setTitle(request.getParameter("title"));
        dto.setContent(request.getParameter("content"));
        boardService.boardInsert(dto);
        return "redirect:list";
    }
    @GetMapping("delete")
    public String boardDelete(HttpServletRequest request, Model model) throws Exception{
        int no = Integer.parseInt(request.getParameter("no"));
        boardService.boardDelete(no);
        return "redirect:list";
    }
    @GetMapping("edit")
    public String editForm(HttpServletRequest request, Model model)throws Exception{
        int no = Integer.parseInt(request.getParameter("no"));
        BoardDTO dto = boardService.getBoard(no);
        model.addAttribute("dto", dto);
        return "/board/boardEdit";
    }
    @PostMapping("edit")
    public String boardEdit(HttpServletRequest request, Model model) throws Exception{
        int no = Integer.parseInt(request.getParameter("no"));
        BoardDTO dto = new BoardDTO();
        dto.setNo(no);
        dto.setTitle(request.getParameter("title"));
        dto.setContent(request.getParameter("content"));
        boardService.boardEdit(dto);
        return "redirect:list";
    }
}
