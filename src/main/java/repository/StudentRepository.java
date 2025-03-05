package dao;

import entity.*;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;

public class StudentRepository {
    private final EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // JPQL

    public List<TrainingSession> getTrainingSessions(Long studentId) {
        return entityManager.createQuery(
                "SELECT ts " +
                        "FROM TrainingSession ts " +
                        "JOIN ts.students s " +
                        "WHERE s.id = :studentId", TrainingSession.class)
                .setParameter("studentId", studentId)
                .getResultList();
    }

    public List<Student> getStudentsByRank(String rank) {
        return entityManager.createQuery(
                "SELECT s " +
                        "FROM Student s " +
                        "WHERE s.rank = :rank", Student.class)
                .setParameter("rank", rank)
                .getResultList();
    }

    public List<Instructor> getInstructorsBySpecialization(String specialization) {
        return entityManager.createQuery(
                "SELECT i " +
                        "FROM Instructor i " +
                        "WHERE i.specialization = :specialization", Instructor.class)
                .setParameter("specialization", specialization)
                .getResultList();
    }

    public List<Student> getStudentsWithProgressReports() {
        return entityManager.createQuery(
                "SELECT s " +
                        "FROM Student s " +
                        "JOIN s.progressReports pr " +
                        "WHERE pr.reportDate >= :threeMonthsAgo", Student.class)
                .setParameter("threeMonthsAgo", LocalDate.now().minusMonths(3))
                .getResultList();
    }


    // Criteria API

    public List<Student> getStudentsSixMonths() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> student = cq.from(Student.class);
        Predicate sixMonths = cb.greaterThanOrEqualTo(student.get("joinDate"), LocalDate.now().minusMonths(6));
        cq.select(student).where(sixMonths);
        return entityManager.createQuery(cq).getResultList();
    }

    public List<TrainingSession> getTrainingSessionsByLocation(String location) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TrainingSession> cq = cb.createQuery(TrainingSession.class);
        Root<TrainingSession> trainingSession = cq.from(TrainingSession.class);
        Predicate trainingLocation = cb.equal(trainingSession.get("location"), location);
        cq.select(trainingSession).where(trainingLocation);
        return entityManager.createQuery(cq).getResultList();
    }

    public List<Instructor> getInstructorsByExperience() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Instructor> cq = cb.createQuery(Instructor.class);
        Root<Instructor> instructor = cq.from(Instructor.class);
        Predicate experience = cb.greaterThan(instructor.get("experienceYears"), 5);
        cq.select(instructor).where(experience);
        return entityManager.createQuery(cq).getResultList();
    }
}
