package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByTitleContaining(String title, Pageable pageable);
}
