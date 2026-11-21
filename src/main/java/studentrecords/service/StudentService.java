
package studentrecords.service;

import java.util.List;
import org.springframework.stereotype.Service;
import studentrecords.model.Student;
import studentrecords.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> searchStudents(String name) {
        return studentRepository.searchByName(name);
    }

    public Student getStudentByRegNo(String regNo) {
        return studentRepository.findByRegNo(regNo);
    }

    public boolean studentExists(String regNo) {
        return studentRepository.existsByRegNo(regNo);
    }

    public void addStudent(Student student) {
        studentRepository.insert(student);
    }

    public void updateStudent(Student student) {
        studentRepository.update(student);
    }

    public void deleteStudent(String regNo) {
        studentRepository.deleteByRegNo(regNo);
    }
}

