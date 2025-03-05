package entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class TrainingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String location;
    private int duration;

    @ManyToMany(mappedBy = "trainingSessions")
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public TrainingSession() {
    }

    public TrainingSession(String date, String location, int duration) {
        this.date = date;
        this.location = location;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
