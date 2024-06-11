package org.example.springboot.service.impl;

import org.example.springboot.entity.Book;
import org.example.springboot.mapper.BookMapper;
import org.example.springboot.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
    @Autowired
    BookMapper bookMapper;
    @Override
    public boolean insert(Book book) {
        int row=bookMapper.insert(book);
        return row>0;
    }
}
