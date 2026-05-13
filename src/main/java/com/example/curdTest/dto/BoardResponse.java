package com.example.curdTest.dto;
import com.example.curdTest.entity.Board;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;


    @Setter
    @Getter
    public class BoardResponse {
        private Long id;
        private String title;
        private String writer;
        private String content;
        private LocalDateTime createdAt;

        public static BoardResponse from(Board board) {
            BoardResponse response = new BoardResponse();
            response.setId(board.getId());
            response.setTitle(board.getTitle());
            response.setWriter(board.getWriter());
            response.setContent(board.getContent());
            response.setCreatedAt(board.getCreatedAt());
            return response;
            // Entity를 응답 DTO로 변환
        }
    }
