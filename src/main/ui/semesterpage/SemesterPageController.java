package ui.semesterpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.CourseList;
import persistence.Writer;
import ui.MainGUI;

import java.io.IOException;

import persistence.Reader;
import ui.semesterpage.addpopup.AddPopUpController;
import ui.semesterpage.viewpopup.ViewPopUpController;

// JavaFX controller for Semester Page
public class SemesterPageController {

    public Label topLabel;

    public Label numberCredits;
    public Label numberCourses;

    public ListView<String> listView;
    public CourseList mainList;

    public Button addButton;
    public Button removeButton;
    public Button detailsButton;
    public Button saveButton;
    public Button backButton;

    public int selectedIndex = -1;

    public Reader reader;
    public Writer writer;

    // EFFECTS: initializes the semester page
    public void initialize() {
        reader = new Reader();
        writer = new Writer();

        loadCourses();
        setLabels();

        for (int i = 0; i < mainList.size(); i++) {
            listView.getItems().add(mainList.getCourse(i).getCourseName());
        }
    }

    // MODIFIES: topLabel
    // EFFECTS: sets the top headline when the user chooses a term
    public void setTopLabel(String text) {
        topLabel.setText(text);
    }

    // MODIFIES: numberCredits, numberCourses
    // EFFECTS: sets information about the semester
    public void setLabels() {
        numberCredits.setText("Total Credits: " + mainList.totalCredits());
        numberCourses.setText("Number of Courses: " + mainList.size());
    }

    // MODIFIES: mainList
    // EFFECTS: loads entered semester's course load from COURSE_FILE, if that file exists;
    //          otherwise creates a new CourseList object
    public void loadCourses() {
        try {
            mainList = reader.load(MainGUI.COURSE_FILE);
        } catch (IOException e) {
            mainList = new CourseList();
        }
    }

    // EFFECTS: saves entered semester's course load to COURSE_FILE
    public void saveCourses() {
        try {
            writer.save(mainList, MainGUI.COURSE_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // MODIFIES: selectedIndex
    // EFFECTS: gets the index of the selected course on mouse click
    public void selectCourse() {
        selectedIndex = listView.getSelectionModel().getSelectedIndex();
    }

    // MODIFIES: mainList, listView
    // EFFECTS: passes the current list of the selected semester
    //          to another pop up window to allow the user to add a course
    public void addCourse() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/semesterpage/addpopup/addpopup.fxml"));
        Parent parent = loader.load();
        AddPopUpController controller = (AddPopUpController) loader.getController();
        controller.passList(mainList, listView);
        Scene scene = new Scene(parent);
        Stage window = new Stage();
        window.getIcons().add(new Image(MainGUI.class.getResourceAsStream("logo.jpg")));
        window.setTitle("Add Course");
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();
    }

    // MODIFIES: mainList, listView
    // EFFECTS: removes the selected course from the current list of the
    //          selected semester
    public void removeCourse() {
        try {
            listView.getItems().remove(selectedIndex);
            mainList.remove(selectedIndex);
        } catch (Exception e) {
            // expected ArrayIndexOutOfBoundsException for -1
        }
    }

    // EFFECTS: passes the current list of the selected semester
    //          to another pop up window to view details of a course
    public void detailCourses() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/semesterpage/viewpopup/viewpopup.fxml"));
            Parent parent = loader.load();
            ViewPopUpController controller = (ViewPopUpController)loader.getController();
            controller.passList(mainList);
            controller.passIndex(selectedIndex);
            controller.getDetails();
            Scene scene = new Scene(parent);
            Stage window = new Stage();
            window.getIcons().add(new Image(MainGUI.class.getResourceAsStream("logo.jpg")));
            window.setTitle("View Courses");
            window.setScene(scene);
            window.initModality(Modality.APPLICATION_MODAL);
            window.show();
        } catch (Exception e) {
            // expected ArrayIndexOutOfBoundsException for -1
        }
    }

    // EFFECTS: takes the application to the homepage
    public void backButtonClicked(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/ui/homepage/homepage.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    // EFFECTS: routes the application to the desired button click
    public void buttonClick(ActionEvent event) throws IOException {
        if (event.getSource() == addButton) {
            addCourse();
        } else if (event.getSource() == removeButton) {
            removeCourse();
        } else if (event.getSource() == detailsButton) {
            detailCourses();
        } else if (event.getSource() == saveButton) {
            saveCourses();
        } else if (event.getSource() == backButton) {
            backButtonClicked(event);
        }
    }
}
