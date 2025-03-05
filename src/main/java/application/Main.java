package application;

import jakarta.persistence.*;
import java.util.List;

import entity.*;
import repository.StudentRepository;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DatabaseWeek7");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StudentRepository studentRepository = new StudentRepository(entityManager);

        List<Student> studentsByRank = studentRepository.getStudentsByRank("Advanced");
        for (Student student : studentsByRank) {
            System.out.println(student.getName());
        }

        List<Student> recentStudents = studentRepository.getStudentsSixMonths();
        for (Student student : recentStudents) {
            System.out.println(student.getName());
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}

