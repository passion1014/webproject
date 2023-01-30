package com.worldchurch.webproject.board.controller;

import com.worldchurch.webproject.board.service.BoardService;
import com.worldchurch.webproject.model.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/list")
    public String boardList(Model model, Pageable pageable) {

        Page<Board> list = boardService.boardList(pageable);
        model.addAttribute("list", list);

        return "board/boardlist";
    }

    @GetMapping("/board/write")
    public String boardWrite() {

        return "boardwrite";
    }

    @PostMapping("/board/write.do")
    public String boardWriteDo(Model model, @RequestBody Board board) {
        boardService.boardWrite(board);

        model.addAttribute("message", "글 작성이 완료되었습니다.");
        model.addAttribute("url", "/board/list");

        return "message";
    }
}
