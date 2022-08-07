package application.dao;

import java.util.ArrayList;
import java.util.List;

import application.model.Course;
import application.sequencer.CourseSequencer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import static application.staticResources.StaticResources.COURSE_FILE;


public class CourseManager extends Thread {

    private List<Course> courses;

    public CourseManager(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Course createCourse(String courseName, int weekDuration) {
        Course course = new Course(CourseSequencer.nextCourseId(), courseName, weekDuration);
        courses.add(course);
        return course;
    }


   //*************************************** Class maintenance ***************************************//
    public void run() {
        saveCourses();
    }

    public void saveCourses() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
            objectWriter.writeValue(COURSE_FILE, courses);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadCourses() {
        List<Course> existingCourses = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            existingCourses = objectMapper.readValue(COURSE_FILE, new TypeReference<List<Course>>() {
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        courses = existingCourses;
    }
    //**************************************************************************************************//

}
