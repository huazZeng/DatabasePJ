package org.example.springboot.mapper;

import org.example.springboot.dto.*;

import java.util.List;

public interface AdvancedMapper {
    List<Foodanalysis> getFoodanalysis(Integer id);

    List<CollectAnalysis> getCollectAnalysis(Integer id);

    List<AgeAnalysis> getAgeAnlysis();

    List<RoleAnalysis> getRoleAnalysis();

    List<GenderAnalysis> getGenderAnalysis();

    List<HabitAnalysis> getHabitAnalysis(Integer id);

    List<HourlyActivityDTO> getHourluActivityDTO();

    List<MonthlyOrderFrequencyDTO> getMonthlyOrderFrequencyDTO();

    List<WeeklyOrderFrequencyDTO> getWeeklyOrder();
}
