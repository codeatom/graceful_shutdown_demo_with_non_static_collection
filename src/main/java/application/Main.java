package application;

import application.sequencer.SequencerInitializer;
import application.sequencer.SequencerTerminator;
import application.dao.CourseManager;
import application.dao.StudentManager;
import application.model.Course;
import application.model.Student;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager(new ArrayList<>());
        CourseManager courseManager = new CourseManager(new ArrayList<>());


        //****************** Load data from JSON and Properties files ***************//
        SequencerInitializer.init();
        studentManager.loadStudents();
        courseManager.loadCourses();
        //***************************************************************************//

        for(Student student : studentManager.getStudents()){
            System.out.println(student.toString() + "\n");
        }

        for(Course course : courseManager.getCourses()){
            System.out.println(course.toString() + "\n");
        }


//        Student student_1 = studentManager.createStudent("Chris Lucky", "cl@yahoo.com");
//        Student student_2 = studentManager.createStudent("Vic Anders", "va@gmail.com");
//        Student student_3 = studentManager.createStudent("Harris Zander", "hz@provider.com");
//
//        Course course_1 = courseManager.createCourse("Java", 10);
//        course_1.getStudents().add(student_1);
//        course_1.getStudents().add(student_2);
//        course_1.getStudents().add(student_3);
//
//        Course course_2 = courseManager.createCourse("C sharp", 10);
//        Course course_3 = courseManager.createCourse("Javascript", 3);



        //************************* Save data to JSON and Properties files **********************//
        Runtime.getRuntime().addShutdownHook(new SequencerTerminator());
        Runtime.getRuntime().addShutdownHook(new StudentManager(studentManager.getStudents()));
        Runtime.getRuntime().addShutdownHook(new CourseManager(courseManager.getCourses()));
        //***************************************************************************************//


        while(true);  //Used to keep the app running in order to simulate closing the app manually.
    }

}