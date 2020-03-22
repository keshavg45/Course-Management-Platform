package ui.semesterpage.addpopup;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.CourseList;

// JavaFX controller for Add Course Pop Up Window
public class AddPopUpController {

    public TextField courseCode;
    public TextField courseNumber;
    public TextField courseCredit;
    public TextField courseLocation;
    public TextField courseTiming;

    public Button addButton;

    public CourseList subMainList;
    public ListView<String> subListView;

    // MODIFIES: subMainList, subListView
    // EFFECTS: gets the course list from the caller
    public void passList(CourseList courseList, ListView<String> listView) {
        subMainList = courseList;
        subListView = listView;
    }

    // EFFECTS: a course is added to the list on button click
    public void addButtonClicked() {
        String cc = courseCode.getText().toUpperCase();
        int cn = Integer.parseInt(courseNumber.getText());
        int cred = Integer.parseInt(courseCredit.getText());
        String cl = courseLocation.getText().toUpperCase();
        String ct = courseTiming.getText().toUpperCase();
        subMainList.addCourse(cc, cn, cred, cl, ct);
        subListView.getItems().add(cc + " " + cn);
        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
    }
}
