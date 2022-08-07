package application.sequencer;

import application.sequencer.CourseSequencer;
import application.sequencer.StudentSequencer;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static application.staticResources.StaticResources.SEQUENCERS_FILE;

public class SequencerInitializer {

    public static void init(){
        Properties properties = new Properties();

        String currentCourseId = "0";
        String currentStudentId = "0";


            try(FileReader reader = new FileReader(SEQUENCERS_FILE)){
                properties.load(reader);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        currentStudentId = properties.getProperty("currentStudentId");
        currentCourseId = properties.getProperty("currentCourseId");

        StudentSequencer.setStudentSequencer(Integer.parseInt(currentStudentId));
        CourseSequencer.setCourseSequencer(Integer.parseInt(currentCourseId));
        }

}
