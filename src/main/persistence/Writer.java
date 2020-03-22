package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.CourseList;

import java.io.FileWriter;
import java.io.IOException;

// A writer that can write course load data to a file
public class Writer {
    private Gson gson;

    // EFFECTS: constructs a writer that will write data to file
    public Writer() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // MODIFIES: this
    // EFFECTS: writes CourseList to .json file in the given path
    public void save(CourseList courseList, String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);

        gson.toJson(courseList, fileWriter);
        fileWriter.close();
    }
}