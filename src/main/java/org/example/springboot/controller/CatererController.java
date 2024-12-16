package org.example.springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.springboot.dto.CatererBrief;
import org.example.springboot.dto.CatererDetail;
import org.example.springboot.dto.Foodanalysis;
import org.example.springboot.dto.OrderDetail;
import org.example.springboot.entity.Caterer;
import org.example.springboot.entity.Food;
import org.example.springboot.entity.Orders;
import org.example.springboot.entity.User;
import org.example.springboot.service.CatererService;
import org.example.springboot.service.FoodService;
import org.example.springboot.service.OrdersService;
import org.example.springboot.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.example.springboot.controller.UserController.SESSION_NAME;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hzz
 * @since 2024-05-31
 */
@RestController
@RequestMapping("/springboot/caterer")
public class CatererController {
    @Autowired
    FoodService foodService;
    @Autowired
    CatererService catererService;
    @Autowired
    OrdersService ordersService;

    @GetMapping("/findBySearch")//2.a&b 这样返回的是全部内容。2个选择：1创建DTO对象 2前端选择性展示
    public List<Caterer> findCaterBySearch(@RequestParam String search){return catererService.findCaterBySearch(search);}

    @GetMapping("/findById")//2.c 3.a查询一个商户的所有信息，包括菜单、菜品概要等,1创建DTO对象 2一个页面同时发送两个请求请求cater信息同时请求对应的菜品
    public Caterer findCaterById(@RequestParam int id){return catererService.findCaterById(id);}

    @GetMapping("/findDetailById")
    public CatererDetail findCaterDetailById(@RequestParam int id){return catererService.findCaterDetailById(id);}

    @GetMapping("/findInterested")
    public List<CatererBrief> findInterested(@RequestParam String search){return catererService.findInterested(search);}


    @GetMapping("/find-my")
    public CatererDetail findMy(HttpServletRequest request){
        Caterer caterer=(Caterer)request.getSession().getAttribute(UserController.SESSION_NAME);
        return catererService.findCaterDetailById(caterer.getId());
    }

    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password, HttpServletRequest request) {
        JsonResult<Caterer> result;
        result=catererService.login(name,password);
        if (result.getState()==1){
            request.getSession().setAttribute(SESSION_NAME,result.getData());
        }
        return result.getMessage();
    }



    @GetMapping("/getAnlysis")
    public List<Foodanalysis> getAnlysis(@RequestParam int id){
        return catererService.getAnalysis(id);
    }

    @PostMapping("/insert")
    public String insertFood(@RequestBody Food food,HttpServletRequest request){
        Caterer caterer=(Caterer)request.getSession().getAttribute(UserController.SESSION_NAME);
//        boolean hasFood=catererService.hasFood(food.getId(),caterer.getId());
//        if (hasFood) return "已有此"
        food.setCatererId(caterer.getId());
        if (foodService.insertFood(food))return "插入成功";
        else return "插入失败";
    }

    @PostMapping("/change-price")
    public String changePrice(@RequestBody Food food,HttpServletRequest request){
        Caterer caterer=(Caterer)request.getSession().getAttribute(UserController.SESSION_NAME);
        boolean hasFood=catererService.hasFood(food.getId(),caterer.getId());
        if (!hasFood) return "你的菜单没有这个菜";
        if (foodService.updateFoodPrice(food)) return "价格成功更新";
        else return "价格更新失败";
    }

    @PostMapping("/change-type")
    public String changeType(@RequestBody Food food,HttpServletRequest request){
        Caterer caterer=(Caterer)request.getSession().getAttribute(UserController.SESSION_NAME);
        boolean hasFood=catererService.hasFood(food.getId(),caterer.getId());
        if (!hasFood) return "你的菜单没有这个菜";
        if (foodService.updateFoodType(food)) return "类型成功更新";
        else return "类型更新失败";
    }

    @GetMapping("/findMyOrder")
    public IPage<Orders> findOrdersForMe(HttpServletRequest request, @RequestParam(name = "pageNumber", defaultValue = "1") int pageNumber,
                                         @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
        Caterer caterer=(Caterer)request.getSession().getAttribute(UserController.SESSION_NAME);
        return ordersService.findOrdersByCatererId(caterer.getId(),pageNumber, pageSize);
    }

    @GetMapping("/completeOrder")
    public String completeOrder(@RequestParam int orderId){
        if(ordersService.complecterId(orderId)) return "order completed";
        else return "failed";
    }

    @GetMapping("/findDetailOrder")
    public OrderDetail findDetailOrder(@RequestParam int orderId){
        return ordersService.findDetailById(orderId);
    }

    @GetMapping("/delete")
    public boolean deleteCaterer(@RequestParam int catererif){

        return catererService.delete(catererif);

    }

    @PostMapping("/update")
    public boolean UpdateCaterer(@RequestBody Caterer caterer){
        Caterer currentUser = catererService.getCatererById(caterer.getId());
        if (currentUser == null) {
            // 如果找不到对应的用户，返回 false
            return false;
        }
        // 更新用户信息
        boolean isUpdated = catererService.updatecaterer(caterer);
        // 返回操作结果
        return isUpdated;
    }


}
