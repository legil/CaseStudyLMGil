package com.casestudy.service;

import com.casestudy.repository.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

}