package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Optional <Student> studentbyEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentbyEmail.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long studentId){
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with "+studentId+" does not exists!");
        }
        studentRepository.deleteById(studentId);
    }
//    @Transactional
//    public void updateStudent(Long studentId) {
//        boolean exists = studentRepository.existsById(studentId);
//        if(!exists){
//            throw new IllegalStateException("Student with "+studentId+" does not exists! add it first");
//        }
//    }
}
