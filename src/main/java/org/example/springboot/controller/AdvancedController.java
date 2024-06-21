package org.example.springboot.controller;

import org.example.springboot.dto.*;
import org.example.springboot.mapper.AdvancedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/springboot/advanced")
public class AdvancedController {
    @Autowired
    AdvancedMapper advancedMapper;
    @GetMapping("/Foodanalysis")
    public List<Foodanalysis> getFoodanalysis(@RequestParam Integer id){
        Foodanalysis foodanalysis =new Foodanalysis();
        List<Foodanalysis> data = advancedMapper.getFoodanalysis(id);

        for (Foodanalysis F:
                data) {


        }
    }
    @GetMapping("/CollectAnalysis")
    public List<CollectAnalysis> getCollectAnalysis(@RequestParam Integer id){
        System.out.println(1);
        return  advancedMapper.getCollectAnalysis(id);
    }
    @GetMapping("/AgeCommentAnalysis")
    public  List<AgeCommentAnalysis> getAgeCommentAnlysis(){
        return advancedMapper.getAgeAnalysis();
    }
    @GetMapping("/RoleCommentAnalysis")
    public  List<RoleCommentAnalysis> getRoleCommentAnalysis(){
        return advancedMapper.getRoleAnalysis();
    }
    @GetMapping("/GenderCommentAnalysis")
    public List<GenderCommentAnalysis> getGenderCommentAnalysis(){
        return advancedMapper.getGenderAnalysis();
    }
    @GetMapping("/AgeOrderAnalysis")
    public  List<AgeOrderAnalysis> getAgeOrderAnlysis(){
        return advancedMapper.getAgeOrderAnalysis();
    }
    @GetMapping("/RoleOrderAnalysis")
    public  List<RoleOrderAnalysis> getRoleOrderAnalysis(){
        return advancedMapper.getRoleOrderAnalysis();
    }

    //fix
    @GetMapping("/GenderOrderAnalysis")
    public List<GenderOrderAnalysis> getGenderOrderAnalysis(){
        return advancedMapper.getGenderOrderAnalysis();
    }
    @GetMapping("/HabitAnalysis")
    public  List<HabitAnalysis> getHabitAnalysis(@RequestParam Integer id){
        return advancedMapper.getHabitAnalysis(id);
    }
    @GetMapping("/hourlyanalysis")
    public  List<HourlyActivityDTO> getHourluActivityDTO(){
        return advancedMapper.getHourluActivityDTO();
    }
    @GetMapping("/monthlyanalysis")
    public  List<MonthlyOrderFrequencyDTO> getMonthlyOrderFrequencyDTO(){
        return  advancedMapper.getMonthlyOrderFrequencyDTO();
    }
    @GetMapping("/weeklyanalysis")
    public List<WeeklyOrderFrequencyDTO> getWeeklyOrder(){
        return  advancedMapper.getWeeklyOrder();
    }
}
