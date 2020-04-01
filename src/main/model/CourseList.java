package model;

import model.exceptions.CourseCodeExceedMaximumException;
import model.exceptions.CourseCreditExceedMaximumException;
import model.exceptions.CourseNumberExceedMaximumException;

import java.util.ArrayList;

public class CourseList {
    public ArrayList<Course> courseList;

    // EFFECTS: constructs a new course list
    public CourseList() {
        courseList = new ArrayList<>();
    }

    /* MODIFIES: this
     * EFFECTS: adds a new course to course list
     */
    public void addCourse(String cc, int cn, int cred, String cl, String ct) throws NumberFormatException,
            CourseCodeExceedMaximumException, CourseCreditExceedMaximumException, CourseNumberExceedMaximumException {
        courseList.add(new Course(cc, cn, cred, cl, ct));
    }

    // EFFECTS: returns size of courseList
    public int size() {
        return courseList.size();
    }

    // EFFECTS: removes course of index i from courseList
    public void remove(int i) {
        courseList.remove(i);
    }

    // EFFECTS: returns index of the course to remove if found else returns -1
    public int removeCourse(String cc, int cn) {
        for (int i = 0; i < courseList.size(); i++) {
            if ((cc.equals(courseList.get(i).getCourseCode())) && (cn == courseList.get(i).getCourseNumber())) {
                return i;
            }
        }
        return -1;
    }

    // EFFECTS: returns index of the course to view if found else returns -1
    public int viewCourse(String cc, int cn) {
        for (int i = 0; i < courseList.size(); i++) {
            if ((cc.equals(courseList.get(i).getCourseCode())) && (cn == courseList.get(i).getCourseNumber())) {
                return i;
            }
        }
        return -1;
    }

    // EFFECTS: returns total credits in the courseList
    public int totalCredits() {
        int s = 0;
        for (int i = 0; i < courseList.size(); i++) {
            s = s + courseList.get(i).getCourseCredits();
        }
        return s;
    }

    public Course getCourse(int i) {
        return courseList.get(i);
    }
}