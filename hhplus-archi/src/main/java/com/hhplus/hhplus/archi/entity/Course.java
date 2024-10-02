package com.hhplus.hhplus.archi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 강의 일련번호

    @Column
    private String name; // 강의 명

    @Column
    private LocalDateTime startDate;  // 수강 신청 시작일자

    @Column
    private LocalDateTime endDate;    // 수강 신청 종료일자

    @Column
    private int enrolledCount; // 신청자 수

    public Course(String name) {
        this.name = name;
        this.enrolledCount = 0;
    }
}
