package application.dao;

import java.util.ArrayList;
import java.util.List;
import application.model.Student;
import application.sequencer.StudentSequencer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import static application.staticResources.StaticResources.STUDENT_FILE;


public class StudentManager extends Thread {

    private List<Student> students;

    public StudentManager(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student createStudent(String name, String email) {
        Student student = new Student(StudentSequencer.nextStudentId(), name, email);
        students.add(student);
        return student;
    }



    //*************************************** Class maintenance ***************************************//
    public void run() {
        saveStudents();
    }

    public void saveStudents(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
            objectWriter.writeValue(STUDENT_FILE, students);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadStudents(){
        List<Student> existingStudents = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            existingStudents = objectMapper.readValue(STUDENT_FILE, new TypeReference<List<Student>>() {});
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        students = existingStudents;
    }
    //**************************************************************************************************//

}