package com.redhun.lingua_notes_api.dto.dashboard;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class DashboardResponse {

    private TodayPatternDto todayPattern;

    private List<CategoryCardDto> popularCategories;

    private List<ContinueLearningDto> continueLearning;
    private int currentStreak;



}