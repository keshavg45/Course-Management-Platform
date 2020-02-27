package persistence;

import com.google.gson.Gson;
import model.CourseList;

import java.io.FileReader;
import java.io.IOException;

// A reader that can read course load data from a file
public class Reader {
    private Gson gson;

    // EFFECTS: constructs a reader that will read data from file
    public Reader() {
        gson = new Gson();
    }

    // MODIFIES: this
    // EFFECTS: reads CourseList from the .json file in the given path
    public CourseList load(String path) throws IOException {
        FileReader reader = new FileReader(path);

        return gson.fromJson(reader, CourseList.class);
    }
}
