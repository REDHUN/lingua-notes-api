package com.redhun.lingua_notes_api.service.impl.dashboard;

import com.redhun.lingua_notes_api.dto.dashboard.CategoryCardDto;
import com.redhun.lingua_notes_api.dto.dashboard.ContinueLearningDto;
import com.redhun.lingua_notes_api.dto.dashboard.DashboardResponse;
import com.redhun.lingua_notes_api.dto.dashboard.TodayPatternDto;
import com.redhun.lingua_notes_api.entity.Category;
import com.redhun.lingua_notes_api.entity.examples.Examples;
import com.redhun.lingua_notes_api.entity.pattern.Pattern;
import com.redhun.lingua_notes_api.entity.userprogress.UserProgress;
import com.redhun.lingua_notes_api.repository.CategoryRepository;
import com.redhun.lingua_notes_api.repository.examples.ExamplesRepository;
import com.redhun.lingua_notes_api.repository.pattern.PatternRepository;
import com.redhun.lingua_notes_api.repository.userprogress.UserProgressRepository;
import com.redhun.lingua_notes_api.service.dashboard.DashboardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final PatternRepository patternRepository;
    private final CategoryRepository categoryRepository;
    private final ExamplesRepository examplesRepository;
    private final UserProgressRepository userProgressRepository;


    public DashboardServiceImpl(
            PatternRepository patternRepository,
            CategoryRepository categoryRepository,
            ExamplesRepository examplesRepository,
            UserProgressRepository userProgressRepository
           ) {

        this.patternRepository = patternRepository;
        this.categoryRepository = categoryRepository;
        this.examplesRepository = examplesRepository;
        this.userProgressRepository=userProgressRepository
      ;
    }

    @Override
    public DashboardResponse getDashboard() {


        // Today's Pattern


        Pattern pattern = patternRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Pattern not found"));

        Examples example = examplesRepository.findByPatternId(pattern.getId())
                .stream()
                .findFirst()
                .orElse(null);

        TodayPatternDto todayPattern = new TodayPatternDto();
        todayPattern.setPatternId(pattern.getId());
        todayPattern.setEnglish(pattern.getEnglish());
        todayPattern.setMalayalam(pattern.getMalayalam());
        todayPattern.setMeaning(pattern.getMeaning());






        // Popular Categories

        Page<Category> categoryPage =
                categoryRepository.findAll(PageRequest.of(0, 5));

        List<CategoryCardDto> categoryCards = new ArrayList<>();

        for (Category category : categoryPage.getContent()) {

            long lessonCount =
                    patternRepository.findByCategoryId(category.getId()).size();

            CategoryCardDto dto = new CategoryCardDto();
            dto.setId(category.getId());
            dto.setName(category.getName());
            dto.setLessonCount(lessonCount);

            categoryCards.add(dto);
        }


        // Continue Learning


        Page<Pattern> patternPage =
                patternRepository.findAll(PageRequest.of(0, 5));

        return getDashboardResponse(patternPage, todayPattern, categoryCards);
    }

    private static DashboardResponse getDashboardResponse(Page<Pattern> patternPage, TodayPatternDto todayPattern, List<CategoryCardDto> categoryCards,) {
        List<ContinueLearningDto> continueLearning = new ArrayList<>();

        for (Pattern item : patternPage.getContent()) {

            ContinueLearningDto dto = new ContinueLearningDto();

            dto.setPatternId(item.getId());
            dto.setEnglish(item.getEnglish());
            dto.setMalayalam(item.getMalayalam());

            continueLearning.add(dto);
        }

        // ===========================
        // Dashboard Response
        // ===========================

        DashboardResponse response = new DashboardResponse();

        UserProgress progress =
                userProgressRepository
                        .findByUserId(userId)
                        .orElseThrow();

        response.setCurrentStreak(
                progress.getCurrentStreak()
        );

        response.setTodayPattern(todayPattern);
        response.setPopularCategories(categoryCards);
        response.setContinueLearning(continueLearning);
        return response;
    }
}