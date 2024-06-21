package org.example.springboot.controller;

import org.example.springboot.dto.*;
import org.example.springboot.mapper.AdvancedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
            return advancedMapper.getFoodanalysis(id);
    }
    @GetMapping("/CollectAnalysis")
    public List<CollectAnalysis> getCollectAnalysis(@RequestParam Integer id){
        return  advancedMapper.getCollectAnalysis(id);
    }
    @GetMapping("/AgeAnalysis")
    public  List<AgeAnalysis> getAgeAnlysis(){
        return advancedMapper.getAgeAnlysis();
    }
    @GetMapping("/RoleAnalysis")
    public  List<RoleAnalysis> getRoleAnalysis(){
        return advancedMapper.getRoleAnalysis();
    }
    @GetMapping("/GenderAnalysis")
    public List<GenderAnalysis> getGenderAnalysis(){
        return advancedMapper.getGenderAnalysis();
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
