package application.staticResources;

import java.io.File;
import java.nio.file.Paths;


public class StaticResources {
    public static final File SEQUENCERS_FILE = new File("src/main/resources/sequencers.properties");
    public static final File STUDENT_FILE = Paths.get("JSON/students.json").toFile();
    public static final File COURSE_FILE = Paths.get("JSON/courses.json").toFile();

}
