package com.hhplus.hhplus.archi.repository.course;

import com.hhplus.hhplus.archi.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // 현재 신청 가능한 강의 목록을 조회하는 쿼리
    List<Course> findAllByStartDateBetweenAndEndDate(LocalDate currentDate);
    Optional<Course> findById(Long courseId);
}
