package model;

// Represents a Course with its course code, number, credits, location and timings
public class Course {
    private String courseCode;
    private int courseNumber;
    private int courseCredits;
    private String courseLocation;
    private String courseTiming;

    /* REQUIRES: courseCode, courseLocation and courseTiming has a non-zero length
    *            courseNumber and courseCredits are > 0
    * MODIFIES: this
    * EFFECTS: instantiates courseCode, courseLocation, courseTiming, courseNumber and courseCredits
    */
    public Course(String courseCode, int courseNumber, int courseCredits, String courseLocation, String courseTiming) {
        this.courseCode = courseCode;
        this.courseNumber = courseNumber;
        this.courseCredits = courseCredits;
        this.courseLocation = courseLocation;
        this.courseTiming = courseTiming;
    }

    public String getCourseCode() {
        return courseCode.toUpperCase();
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public String getCourseLocation() {
        return courseLocation.toUpperCase();
    }

    public String getCourseTiming() {
        return courseTiming.toUpperCase();
    }

    public String getCourseName() {
        return courseCode.toUpperCase() + " " + courseNumber;
    }
}