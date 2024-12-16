package org.example.springboot.controller;

import org.example.springboot.entity.Caterer;
import org.example.springboot.entity.CatererComment;
import org.example.springboot.service.CatererCommentService;
import org.example.springboot.service.CatererService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

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
@RequestMapping("/springboot/catererComment")
public class CatererCommentController {

    @Autowired
    CatererCommentService catererCommentService;

    @GetMapping("/findByCatererId")//获得某个商户的全部评价和评分呢
    public List<CatererComment> findCatererCommentByCatererId(@RequestParam int catererId){return catererCommentService.findCatererCommentByCatererId(catererId);}
    @PostMapping("/InsertComment")
    public boolean InsertComment(@RequestBody CatererComment comment){
        boolean isInserted = catererCommentService.insert(comment);
        // 返回操作结果
        return isInserted;
    }

}
