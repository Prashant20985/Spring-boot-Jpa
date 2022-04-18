package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Course;
import com.example.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ITeacherRepositoryTest {

    @Autowired
    private ITeacherRepository repository;

    @Test
    public void saveTeacher(){
        Course courseSBD = Course.builder()
                .title("SBD")
                .credit(4)
                .build();
        Course courseJava = Course.builder()
                .title("PPJ")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Tomasz")
                .LastName("Werner")
                //.course(List.of(courseJava,courseSBD))
                .build();

        repository.save(teacher);
    }
}