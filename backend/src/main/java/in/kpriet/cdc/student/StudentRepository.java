package in.kpriet.cdc.student;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByDepartmentIgnoreCase(String department);
    List<Student> findByPlacementStatusIgnoreCase(String placementStatus);
}
