package com.hhplus.hhplus.archi.service.enrollment;

import com.hhplus.hhplus.archi.entity.Course;
import com.hhplus.hhplus.archi.entity.Enrollment;
import com.hhplus.hhplus.archi.entity.User;
import com.hhplus.hhplus.archi.repository.course.CourseRepository;
import com.hhplus.hhplus.archi.repository.enrollment.EnrollmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public Enrollment enroll(Long courseId, Long userId) {

        boolean alreadyEnrolled = enrollmentRepository.existsByUserIdAndCourseId(courseId, userId);

        if (alreadyEnrolled) {
            throw new IllegalStateException("이미 선택된 강좌입니다.");
        }

        Optional<Course> courseOptional = courseRepository.findById(courseId);
        Course course = courseOptional.orElseThrow(
                () -> new IllegalStateException("해당 강좌를 찾을 수 없습니다.")
        );

        if (course.getEnrolledCount() >= 30) {
            throw new IllegalStateException("수강정원을 초과하였습니다.");
        }

        course.setEnrolledCount(course.getEnrolledCount() + 1);

        Enrollment enrollment = new Enrollment(new User(userId), course);
        enrollmentRepository.save(enrollment);

        return enrollment;
    }

    public List<Enrollment> getCoursesByUserId(Long userId) {
        return enrollmentRepository.findByUserId(userId);
    }
}
