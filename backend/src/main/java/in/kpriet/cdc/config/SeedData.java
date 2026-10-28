package in.kpriet.cdc.config;

import in.kpriet.cdc.student.Student;
import in.kpriet.cdc.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeedData {
    @Bean
    CommandLineRunner seedStudents(StudentRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Student("24CBL03","Aarav Kumar","CSE","2024",8.7,"Placed","Zoho","React, Java, SQL"));
                repo.save(new Student("23CB001","Ananya S","ECE","2023",9.1,"Interviewing","—","Python, ML, Data Analysis"));
                repo.save(new Student("24CSE12","Pranav R","CSE","2024",7.9,"Eligible","—","Java, Spring Boot, Git"));
                repo.save(new Student("23EEE18","Divya M","EEE","2023",8.4,"Placed","TCS","C++, IoT, Python"));
                repo.save(new Student("24IT009","Karthik P","IT","2024",8.2,"Eligible","—","JavaScript, React, Figma"));
                repo.save(new Student("23ME021","Nithya V","MECH","2023",8.8,"Placed","L&T","CAD, Python, Analysis"));
            }
        };
    }
}
