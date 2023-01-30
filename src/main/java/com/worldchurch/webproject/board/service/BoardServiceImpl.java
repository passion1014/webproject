package com.worldchurch.webproject.board.service;

import com.worldchurch.webproject.board.dto.BoardDto;
import com.worldchurch.webproject.model.entity.Board;
import com.worldchurch.webproject.model.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Page<Board> boardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Override
    public void boardWrite(Board board) {
        boardRepository.save(board);
    }
}
