package com.hhplus.hhplus.archi.controller.course;

import com.hhplus.hhplus.archi.entity.Course;
import com.hhplus.hhplus.archi.service.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    // 신청 가능한 강의 목록보기
    @GetMapping("/available")
    public List<Course> getAvailableCourses() {
        return  courseService.getAvailableCourses();
    }
}



