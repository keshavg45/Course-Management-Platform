package ui.semesterpage.viewpopup;

import javafx.scene.control.TextField;
import model.Course;
import model.CourseList;

// JavaFX controller for View Course Pop Up Window
public class ViewPopUpController {

    public TextField courseCode;
    public TextField courseNumber;
    public TextField courseCredit;
    public TextField courseLocation;
    public TextField courseTiming;

    public CourseList subMainList;
    public Course course;

    public int index;

    // MODIFIES: subMainList
    // EFFECTS: gets the course list from the caller
    public void passList(CourseList courseList) {
        subMainList = courseList;
    }

    // MODIFIES: index
    // EFFECTS: gets the index of the course from the caller
    public void passIndex(int i) {
        index = i;
        course = subMainList.getCourse(i);
    }

    // EFFECTS: displays the details of the selected course
    public void getDetails() {
        courseCode.setText(course.getCourseCode());
        courseNumber.setText(Integer.toString(course.getCourseNumber()));
        courseCredit.setText(Integer.toString(course.getCourseCredits()));
        courseLocation.setText(course.getCourseLocation());
        courseTiming.setText(course.getCourseTiming());
    }

}
