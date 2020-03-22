package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

// Course Management Platform (CMP) Graphical User Interface
public class MainGUI extends Application {

    public static String COURSE_FILE;

    public static void main(String[] args) {
        launch(args);
    }

    // EFFECTS: starts the application
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("loginpage/loginpage.fxml"));
        primaryStage.getIcons().add(new Image(MainGUI.class.getResourceAsStream("logo.jpg")));
        primaryStage.setTitle("Course Management Platform (CMP)");
        Scene scene = new Scene(root, 800, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}