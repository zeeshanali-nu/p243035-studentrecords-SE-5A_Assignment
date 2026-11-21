

package studentrecords.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import studentrecords.model.Student;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Get all students
    public List<Student> findAll() {

        String sql = "SELECT * FROM students";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new Student(
                rs.getInt("id"),
                rs.getString("reg_no"),
                rs.getString("name"),
                rs.getString("department"),
                rs.getDouble("cgpa")
            )
        );
    }

    // Search students by name
    public List<Student> searchByName(String name) {

        String sql = "SELECT * FROM students WHERE LOWER(name) LIKE LOWER(?)";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new Student(
                rs.getInt("id"),
                rs.getString("reg_no"),
                rs.getString("name"),
                rs.getString("department"),
                rs.getDouble("cgpa")
            ),
            "%" + name + "%"
        );
    }

    // Find student using registration number
    public Student findByRegNo(String regNo) {

        String sql = "SELECT * FROM students WHERE reg_no = ?";

        List<Student> students = jdbcTemplate.query(sql, (rs, rowNum) ->
            new Student(
                rs.getInt("id"),
                rs.getString("reg_no"),
                rs.getString("name"),
                rs.getString("department"),
                rs.getDouble("cgpa")
            ),
            regNo
        );

        if (students.isEmpty()) {
            return null;
        }

        return students.get(0);
    }

    // Check whether registration number already exists
    public boolean existsByRegNo(String regNo) {

        String sql = "SELECT COUNT(*) FROM students WHERE reg_no = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, regNo);

        return count != null && count > 0;
    }

    // Insert a new student
    public void insert(Student student) {

        String sql = "INSERT INTO students (reg_no, name, department, cgpa) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(
            sql,
            student.getRegNo(),
            student.getName(),
            student.getDepartment(),
            student.getCgpa()
        );
    }

    // Update an existing student
    public void update(Student student) {

        String sql = "UPDATE students SET name = ?, department = ?, cgpa = ? WHERE reg_no = ?";

        jdbcTemplate.update(
            sql,
            student.getName(),
            student.getDepartment(),
            student.getCgpa(),
            student.getRegNo()
        );
    }

    // Delete student using registration number
    public void deleteByRegNo(String regNo) {

        String sql = "DELETE FROM students WHERE reg_no = ?";

        jdbcTemplate.update(sql, regNo);
    }
}

