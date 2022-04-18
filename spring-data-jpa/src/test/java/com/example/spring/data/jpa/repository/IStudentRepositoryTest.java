package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Guardian;
import com.example.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class IStudentRepositoryTest {
    @Autowired
    private IStudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("Prashant")
                .firstName("prashant@gmail.com")
                .lastName("Sharma")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("xyz")
                .email("xyxy@gmail.com")
                .mobile("7896665412")
                .build();

        Student student = Student.builder()
                .firstName("prashant2")
                .lastName("sharma2")
                .guardian(guardian)
                .emailId("prashant2@gmail.com")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void getStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void getStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("prashant2");
        System.out.println("Students = "+students);
    }

    @Test
    public void getStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("pr");
        System.out.println("Students = "+students);
    }

    @Test
    public void getStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("xyz");
        System.out.println("Students = "+students);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student student = studentRepository
                .getStudentByEmailAddress("prashant2@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentFirstNameByEmailAddress(){
        String firstName = studentRepository
                .getStudentFirstNameByEmailAddress("prashant2@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student student = studentRepository
                .getStudentByEmailAddressNative("prashant2@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository
                .getStudentByEmailAddressNativeNamedParam("prashant2@gmail.com");
        System.out.println(student);

    }

    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId(
                "Jon",
                "prashant2@gmail.com"
        );
    }

}