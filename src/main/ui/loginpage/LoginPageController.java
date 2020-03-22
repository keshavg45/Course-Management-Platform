package ui.loginpage;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// JavaFX controller for Login Window
public class LoginPageController {

    public Button logInButton;
    public Label liveTime;

    public TextField username;
    public PasswordField password;
    public Label loginStatus;

    // EFFECTS: initializes the live time on bottom right of the application
    public void initialize() {
        getLiveTime(liveTime);
    }

    // EFFECTS: authenticates user login
    public void logInClicked(ActionEvent event) throws IOException {
        if (event.getSource() == logInButton) {
            if (username.getText().equals("keshavg") && password.getText().equals("qwerty")) {
                loginStatus.setText("Successfully logged in!");
                Parent parent = FXMLLoader.load(getClass().getResource("/ui/homepage/homepage.fxml"));
                Scene scene = new Scene(parent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            } else {
                loginStatus.setText("Invalid credentials!");
            }
        }
    }

    // Taken from: https://stackoverflow.com/a/52785067
    public void getLiveTime(Label liveTime) {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            liveTime.setText(LocalDateTime.now().format(formatter));
            liveTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}
