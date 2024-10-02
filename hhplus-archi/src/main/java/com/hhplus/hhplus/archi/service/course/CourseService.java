package com.hhplus.hhplus.archi.service.course;

import com.hhplus.hhplus.archi.entity.Course;
import com.hhplus.hhplus.archi.repository.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    @Value("${course.max-enrollment}")
    private int maxEnrollment;

    public List<Course> getAvailableCourses() {
        LocalDate currentDate = LocalDate.now();
        return courseRepository.findAllByStartDateBetweenAndEndDate(currentDate);
    }
}
