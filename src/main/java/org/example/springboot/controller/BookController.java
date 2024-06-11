package org.example.springboot.controller;

import org.example.springboot.entity.Book;
import org.example.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
@RestController
@RequestMapping("/springboot/book")
public class BookController {
    @Autowired
    BookService bookService;
    @RequestMapping("/insert")
    public  boolean insert(@RequestBody Book book){
        return bookService.insert(book);
    }
}
