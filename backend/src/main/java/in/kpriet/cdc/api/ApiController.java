package in.kpriet.cdc.api;

import in.kpriet.cdc.student.Student;
import in.kpriet.cdc.student.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final StudentRepository students;
    public ApiController(StudentRepository students) { this.students = students; }

    @GetMapping("/health")
    public Map<String,String> health() { return Map.of("status","ok","service","KPRIET CDC API"); }

    @PostMapping("/auth/login")
    public Map<String,Object> login(@RequestBody LoginRequest request) {
        if (request == null || request.id() == null || request.password() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID and password are required");
        String id = request.id().trim().toUpperCase(Locale.ROOT);
        if (List.of("CDC01","TP026").contains(id) && "StaffID123".equals(request.password()))
            return Map.of("id", id, "role", "Staff", "displayName", "CDC Staff");
        if (List.of("24CBL03","23CB001").contains(id) && "StudentID123".equals(request.password())) {
            Student student = students.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student profile not found"));
            return Map.of("id", id, "role", "Student", "displayName", student.getFullName());
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid ID or password");
    }

    @GetMapping("/students")
    public List<Student> allStudents() { return students.findAll(); }

    @GetMapping("/students/{id}")
    public Student student(@PathVariable String id) {
        return students.findById(id.toUpperCase(Locale.ROOT))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable String id, @Valid @RequestBody Student incoming) {
        String key = id.toUpperCase(Locale.ROOT);
        Student existing = students.findById(key).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        existing.setFullName(incoming.getFullName());
        existing.setDepartment(incoming.getDepartment()); existing.setBatchYear(incoming.getBatchYear());
        existing.setCgpa(incoming.getCgpa()); existing.setEmail(incoming.getEmail()); existing.setPhone(incoming.getPhone());
        existing.setPlacementStatus(incoming.getPlacementStatus()); existing.setCompany(incoming.getCompany());
        existing.setCareerInterest(incoming.getCareerInterest()); existing.setPreferredLocation(incoming.getPreferredLocation());
        existing.setInternshipExperience(incoming.getInternshipExperience()); existing.setProjects(incoming.getProjects());
        existing.setSkillsCsv(incoming.getSkillsCsv());
        return students.save(existing);
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@Valid @RequestBody Student student) {
        if (student.getStudentId() == null || student.getStudentId().isBlank()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student ID is required");
        String id=student.getStudentId().trim().toUpperCase(Locale.ROOT);
        if (students.existsById(id)) throw new ResponseStatusException(HttpStatus.CONFLICT, "Student ID already exists");
        student.setStudentId(id); student.setDemoRecord(false);
        return students.save(student);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable String id) {
        if (!students.existsById(id.toUpperCase(Locale.ROOT))) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        students.deleteById(id.toUpperCase(Locale.ROOT));
    }

    public record LoginRequest(String id, String password) {}
}
