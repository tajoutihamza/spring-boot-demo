package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student Refka = new Student(2L,
                    "Refka",
                    "Refka.benmarzouk@gmail.com",
                    LocalDate.of(1999, Month.SEPTEMBER,9));
            Student Hamza = new Student(
                    "Hamza",
                    "Hamza.taoujouti@gmail.com",
                    LocalDate.of(1999, Month.FEBRUARY,28));
            Student Hama = new Student(
                    "Hama",
                    "Hamza.taoujouti@gmail.com",
                    LocalDate.of(1999, Month.FEBRUARY,28));
            repository.saveAll(List.of(Hamza,Refka,Hama));
        };
    }
}
