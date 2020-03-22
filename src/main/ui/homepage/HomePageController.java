package ui.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ui.MainGUI;
import ui.semesterpage.SemesterPageController;

import java.io.IOException;

// JavaFX controller for Login Window
public class HomePageController {

    public Button winterTerm1;
    public Button winterTerm2;
    public Button summerTerm1;
    public Button summerTerm2;
    public Button viewLogo;

    // EFFECTS: routes the application to the desired semester selection
    public void termSelected(ActionEvent event) throws IOException {
        if (event.getSource() == winterTerm1) {
            enterSemester("WT1");
            switchScenes(event, "Winter Term 1");
        } else if (event.getSource() == winterTerm2) {
            enterSemester("WT2");
            switchScenes(event, "Winter Term 2");
        } else if (event.getSource() == summerTerm1) {
            enterSemester("ST1");
            switchScenes(event, "Summer Term 1");
        } else if (event.getSource() == summerTerm2) {
            enterSemester("ST2");
            switchScenes(event, "Summer Term 2");
        }
    }

    // EFFECTS: shows the image of the logo for this application (audiovisual component)
    public void logoPopUp() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/homepage/viewlogo.fxml"));
            Parent parent = loader.load();
            HomePageController controller = (HomePageController) loader.getController();
            Scene scene = new Scene(parent);
            Stage window = new Stage();
            window.getIcons().add(new Image(MainGUI.class.getResourceAsStream("logo.jpg")));
            window.setTitle("Logo");
            window.setScene(scene);
            window.initModality(Modality.APPLICATION_MODAL);
            window.show();
        } catch (IOException e) {
            //
        }
    }

    // EFFECTS: switches page to semester page on selection
    public void switchScenes(ActionEvent event, String text) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/semesterpage/semesterpage.fxml"));
        Parent courseParent = loader.load();
        SemesterPageController controller = (SemesterPageController)loader.getController();
        controller.setTopLabel(text);
        Scene courseScene = new Scene(courseParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(courseScene);
        window.show();
    }

    // MODIFIES: COURSE_FILE
    // EFFECTS: lets the user enter their semester
    public void enterSemester(String semester) {
        MainGUI.COURSE_FILE =  "./data/" + semester + ".json";
    }

}

