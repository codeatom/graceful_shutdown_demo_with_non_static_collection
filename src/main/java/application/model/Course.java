package application.model;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private int id;
    private String courseName;
    private int weekDuration;
    private List<Student> students = new ArrayList<>();


    public Course() {
    }

    public Course(int id, String courseName, int weekDuration) {
        this.id = id;
        this.courseName = courseName;
        this.weekDuration = weekDuration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "course id: " + id + "\n"
                + "course name: " + courseName + "\n"
                + "course duration: " + weekDuration + " weeks";
    }
}