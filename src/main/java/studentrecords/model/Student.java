
package studentrecords.model;

public class Student {

    private int id;
    private String regNo;
    private String name;
    private String department;
    private Double cgpa;

    public Student() {
    }

    public Student(int id, String regNo, String name, String department, Double cgpa) {
        this.id = id;
        this.regNo = regNo;
        this.name = name;
        this.department = department;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }
}
