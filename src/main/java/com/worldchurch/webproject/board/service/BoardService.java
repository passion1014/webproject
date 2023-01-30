package com.worldchurch.webproject.board.service;

import com.worldchurch.webproject.board.dto.BoardDto;
import com.worldchurch.webproject.model.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {

    public Page<Board> boardList(Pageable pageable);

    public void boardWrite(Board board);


}
