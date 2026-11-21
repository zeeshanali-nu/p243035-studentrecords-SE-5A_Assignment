
package studentrecords.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import studentrecords.model.Student;
import studentrecords.service.StudentService;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 1. Display all students and search by name
    @GetMapping("/students")
    public String getAllStudents(
            @RequestParam(required = false) String name,
            Model model) {

        List<Student> students;

        if (name != null && !name.isEmpty()) {
            students = studentService.searchStudents(name);
        } else {
            students = studentService.getAllStudents();
        }

        model.addAttribute("students", students);
        model.addAttribute("searchName", name);

        return "students";
    }

    // 2. Display student details
    @GetMapping("/students/{regNo}")
    public String getStudentDetails(
            @PathVariable String regNo, Model model) {

        Student student = studentService.getStudentByRegNo(regNo);

        if (student == null) {
            return "redirect:/students";
        }

        model.addAttribute("student", student);

        return "student-details";
    }

    // 3. Open new student form
    @GetMapping("/students/new")
    public String showStudentForm(Model model) {

        model.addAttribute("student", new Student());

        return "student-form";
    }

    // 4. Save new student
    @PostMapping("/students")
    public String addStudent(@ModelAttribute Student student) {

        if (studentService.studentExists(student.getRegNo())) {
            return "redirect:/students";
        }

        studentService.addStudent(student);

        return "redirect:/students";
    }

    // 5. Open edit student form
    @GetMapping("/students/{regNo}/edit")
    public String showEditForm(
            @PathVariable String regNo, Model model) {

        Student student = studentService.getStudentByRegNo(regNo);

        if (student == null) {
            return "redirect:/students";
        }

        model.addAttribute("student", student);

        return "student-form";
    }

    // 6. Update student
    @PostMapping("/students/{regNo}/update")
    public String updateStudent(
            @PathVariable String regNo,
            @ModelAttribute Student student) {

        student.setRegNo(regNo);
        studentService.updateStudent(student);

        return "redirect:/students";
    }

    // 7. Delete student
    @PostMapping("/students/{regNo}/delete")
    public String deleteStudent(@PathVariable String regNo) {

        studentService.deleteStudent(regNo);

        return "redirect:/students";
    }
}

