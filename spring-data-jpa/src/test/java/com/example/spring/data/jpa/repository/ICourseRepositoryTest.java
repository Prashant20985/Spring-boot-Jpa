package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Course;
import com.example.spring.data.jpa.entity.Student;
import com.example.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class ICourseRepositoryTest {
    @Autowired
    private ICourseRepository repository;

    @Test
    public void printCourses(){
        List<Course> course =
                repository.findAll();
        System.out.println(course);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Tony")
                .LastName("Stark")
                .build();

        Course course = Course.builder()
                .title("NAI")
                .credit(6)
                .teacher(teacher)
                .build();
        repository.save(course);
    }

    @Test
    public void finaAllPagination(){
        Pageable firstPageWithThreeRecords =  PageRequest.of(0,3);
        Pageable SecondPageWithTwoRecords = PageRequest.of(1,2);

        List<Course> courses = repository
                .findAll(firstPageWithThreeRecords)
                .getContent();

        long totalElements = repository
                .findAll(firstPageWithThreeRecords)
                .getTotalElements();

        long totalPages = repository
                .findAll(firstPageWithThreeRecords)
                .getTotalPages();

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest
                .of(0,2, Sort.by("Title"));

        Pageable sortByCreditDesc = PageRequest
                .of(1,2,Sort.by("credit").descending());
        
        List<Course> courses = repository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void findByTitleContaining(){
        Pageable firstPageTenRecords = PageRequest
                .of(0,10);

        List<Course> courses =
                repository.findByTitleContaining("D", firstPageTenRecords);
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Jhon")
                .LastName("Wick")
                .build();

        Student student = Student.builder()
                .firstName("Nikhil")
                .lastName("singh")
                .emailId("nikil@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit(5)
                .teacher(teacher)
                .build();
        course.addStudents(student);
        repository.save(course);
    }
}