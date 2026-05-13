package com.example.curdTest.controller;

import com.example.curdTest.dto.BoardRequest;
import com.example.curdTest.dto.BoardResponse;
import com.example.curdTest.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
class BoardController {
    private final BoardService boardService;

    @PostMapping
    public BoardResponse create(@RequestBody BoardRequest request) {
        return boardService.create(request);
    }

    @GetMapping
    public List<BoardResponse> findAll() {
        return boardService.findAll();
    }
    @GetMapping("/{id}")
    public BoardResponse findOne(@PathVariable Long id) {
        return boardService.findOne(id);
    }

    @PutMapping("/{id}")
    public BoardResponse update(@PathVariable Long id,
                                @RequestBody BoardRequest request) {
        return boardService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}