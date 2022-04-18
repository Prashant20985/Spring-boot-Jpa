package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
}
