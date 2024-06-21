package org.example.springboot.service.impl;

import org.example.springboot.entity.Book;
import org.example.springboot.mapper.AdvancedMapper;
import org.example.springboot.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvancedServiceImpl {
    @Autowired
    AdvancedMapper advancedMapper;


}
