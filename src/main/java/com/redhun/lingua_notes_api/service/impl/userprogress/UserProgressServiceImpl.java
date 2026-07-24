package com.redhun.lingua_notes_api.service.impl.userprogress;

import com.redhun.lingua_notes_api.entity.userprogress.UserProgress;
import com.redhun.lingua_notes_api.repository.userprogress.UserProgressRepository;
import com.redhun.lingua_notes_api.service.userprogress.UserProgressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class UserProgressServiceImpl implements UserProgressService {

    @Autowired
    UserProgressRepository userProgressRepository;

    @Override
    public void updateStreak() {

        UserProgress progress = userProgressRepository
                .findByUserId(1L)
                .orElseThrow();

        LocalDate today = LocalDate.now();

        if (progress.getLastLearningDate() == null) {

            progress.setCurrentStreak(1);

        } else {

            long days = ChronoUnit.DAYS.between(
                    progress.getLastLearningDate(),
                    today
            );

            if (days == 0) {

                return;

            } else if (days == 1) {

                progress.setCurrentStreak(
                        progress.getCurrentStreak() + 1
                );

            } else {

                progress.setCurrentStreak(1);

            }

        }

        progress.setLastLearningDate(today);

        if (progress.getCurrentStreak()
                > progress.getLongestStreak()) {

            progress.setLongestStreak(
                    progress.getCurrentStreak()
            );

        }

        userProgressRepository.save(progress);
    }
}
