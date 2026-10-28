package in.kpriet.cdc.student;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id @Column(length = 30)
    private String studentId;
    @NotBlank @Column(nullable = false) private String fullName;
    private String department;
    private String batchYear;
    @DecimalMin("0.0") @DecimalMax("10.0") private Double cgpa;
    private String email;
    private String phone;
    private String placementStatus = "Eligible";
    private String company;
    private String careerInterest;
    private String preferredLocation;
    private String internshipExperience;
    @Column(length = 2000) private String projects;
    @Column(length = 2000) private String skillsCsv;
    private boolean demoRecord = true;

    protected Student() {}
    public Student(String id, String name, String dept, String batch, double cgpa, String status, String company, String skills) {
        this.studentId=id; this.fullName=name; this.department=dept; this.batchYear=batch; this.cgpa=cgpa;
        this.placementStatus=status; this.company=company; this.skillsCsv=skills; this.demoRecord=true;
    }
    public String getStudentId(){return studentId;} public void setStudentId(String v){studentId=v;}
    public String getFullName(){return fullName;} public void setFullName(String v){fullName=v;}
    public String getDepartment(){return department;} public void setDepartment(String v){department=v;}
    public String getBatchYear(){return batchYear;} public void setBatchYear(String v){batchYear=v;}
    public Double getCgpa(){return cgpa;} public void setCgpa(Double v){cgpa=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
    public String getPlacementStatus(){return placementStatus;} public void setPlacementStatus(String v){placementStatus=v;}
    public String getCompany(){return company;} public void setCompany(String v){company=v;}
    public String getCareerInterest(){return careerInterest;} public void setCareerInterest(String v){careerInterest=v;}
    public String getPreferredLocation(){return preferredLocation;} public void setPreferredLocation(String v){preferredLocation=v;}
    public String getInternshipExperience(){return internshipExperience;} public void setInternshipExperience(String v){internshipExperience=v;}
    public String getProjects(){return projects;} public void setProjects(String v){projects=v;}
    public String getSkillsCsv(){return skillsCsv;} public void setSkillsCsv(String v){skillsCsv=v;}
    public boolean isDemoRecord(){return demoRecord;} public void setDemoRecord(boolean v){demoRecord=v;}
}
