package org.example.springboot.controller;

import org.example.springboot.entity.Messages;
import org.example.springboot.entity.Orders;
import org.example.springboot.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
@RestController
@RequestMapping("/springboot/messages")
public class MessagesController {
    @Autowired
    MessagesService messagesService;
    @GetMapping("/findByUserId")
    public List<Messages> findOrdersByUserId(@RequestParam int userId){return messagesService.findMessageByUserId(userId);}
}
