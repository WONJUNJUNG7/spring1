package com.example.curdTest.service;

import com.example.curdTest.dto.BoardRequest;
import com.example.curdTest.dto.BoardResponse;
import com.example.curdTest.entity.Board;
import com.example.curdTest.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardResponse create(BoardRequest request) {
        Board board = new Board();
        board.setTitle(request.getTitle());
        board.setWriter(request.getWriter());
        board.setContent(request.getContent());
        return BoardResponse.from(boardRepository.save(board));
    }

    @Transactional(readOnly = true)
    public List<BoardResponse> findAll() {
        return boardRepository.findAll().stream()
                .map(BoardResponse::from)
                .toList();
    }
    public BoardResponse findOne(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다."));
        return BoardResponse.from(board);
    }

    public BoardResponse update(Long id, BoardRequest request) {
        Board board = boardRepository.findById(id).orElseThrow();
        board.setTitle(request.getTitle());
        board.setWriter(request.getWriter());
        board.setContent(request.getContent());
        return BoardResponse.from(board);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}