package application.sequencer;

import java.io.*;
import java.util.Properties;

import application.sequencer.CourseSequencer;
import application.sequencer.StudentSequencer;
import static application.staticResources.StaticResources.SEQUENCERS_FILE;


public class SequencerTerminator extends Thread{

    public void run() {
        Properties properties = new Properties();
        properties.setProperty("currentStudentId", String.valueOf(StudentSequencer.getStudentSequencer()));
        properties.setProperty("currentCourseId", String.valueOf(CourseSequencer.getCourseSequencer()));

        try(FileWriter writer = new FileWriter(SEQUENCERS_FILE)){
            properties.store(writer, "Latest sequencer values");
        }catch (IOException ex){
            ex.getMessage();
        }
    }

}