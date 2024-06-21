package org.example.springboot.controller;

import org.example.springboot.entity.CatererCollect;
import org.example.springboot.entity.CatererComment;
import org.example.springboot.service.CatererCollectService;
import org.example.springboot.service.CatererCommentService;
import org.example.springboot.service.CatererService;
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
 * @since 2024-06-11
 */
@RestController
@RequestMapping("/springboot/catererCollect")
public class CatererCollectController {
    @Autowired
    CatererCollectService catererCollectService;
    @RequestMapping("/insert")
    public  boolean insertCatererCollect(@RequestBody CatererCollect catererCollect){
           return  catererCollectService.insert(catererCollect);
    }

}
