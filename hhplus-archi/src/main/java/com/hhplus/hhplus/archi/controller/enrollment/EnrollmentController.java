package com.hhplus.hhplus.archi.controller.enrollment;

import com.hhplus.hhplus.archi.dto.EnrollmentDto;
import com.hhplus.hhplus.archi.entity.Enrollment;
import com.hhplus.hhplus.archi.service.enrollment.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enrollment")
public class EnrollmentController {

    private static final Logger log = LoggerFactory.getLogger(EnrollmentController.class);

    private final EnrollmentService enrollmentService;

    // 강의 신청하기
    @PostMapping("{courseId}/enroll")
    public Enrollment enroll(@PathVariable long courseId, @RequestBody long userId) {
        return enrollmentService.enroll(courseId,userId);
    }

    // 내가 신청한 강의 목록 보기
    @GetMapping("/{userId}/list")
    public List<Enrollment> getMyCourses(@PathVariable Long userId) {
        return enrollmentService.getCoursesByUserId(userId);
    }
}
