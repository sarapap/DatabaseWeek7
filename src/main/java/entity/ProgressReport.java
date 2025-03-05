package entity;

import jakarta.persistence.*;

@Entity
public class ProgressReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reportDate;
    private String achievements;
    private String areasForImprovement;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Version
    private int version;

    public ProgressReport() {
    }

    public ProgressReport(String reportDate, String achievements, String areasForImprovement) {
        this.reportDate = reportDate;
        this.achievements = achievements;
        this.areasForImprovement = areasForImprovement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public String getAreasForImprovement() {
        return areasForImprovement;
    }

    public void setAreasForImprovement(String areasForImprovement) {
        this.areasForImprovement = areasForImprovement;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
