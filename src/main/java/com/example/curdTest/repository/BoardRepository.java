package com.example.curdTest.repository;

import com.example.curdTest.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository
        extends JpaRepository<Board, Long> {
}