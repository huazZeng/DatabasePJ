package org.example.springboot.mapper;

import org.example.springboot.dto.*;

import java.util.List;

public interface AdvancedMapper {
    List<Foodanalysis> getFoodanalysis(Integer id);

    List<CollectAnalysis> getCollectAnalysis(Integer id);

    List<AgeCommentAnalysis> getAgeAnlysis();

    List<RoleCommentAnalysis> getRoleAnalysis();

    List<GenderCommentAnalysis> getGenderAnalysis();

    List<HabitAnalysis> getHabitAnalysis(Integer id);

    List<HourlyActivityDTO> getHourluActivityDTO();

    List<MonthlyOrderFrequencyDTO> getMonthlyOrderFrequencyDTO();

    List<WeeklyOrderFrequencyDTO> getWeeklyOrder();

    List<RoleOrderAnalysis> getRoleOrderAnalysis();

    List<GenderOrderAnalysis> getGenderOrderAnalysis();

    List<AgeOrderAnalysis> getAgeOrderAnalysis();
}
