package model;

import model.Course;

import static org.junit.jupiter.api.Assertions.*;

import model.exceptions.CourseCodeExceedMaximumException;
import model.exceptions.CourseCreditExceedMaximumException;
import model.exceptions.CourseNumberExceedMaximumException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Unit tests for the Course class
class CourseListTest {
    public CourseList courseList1;
    public Course courseForTest;
    public Course courseToBeTested;

    CourseListTest() throws CourseCodeExceedMaximumException, CourseCreditExceedMaximumException,
            CourseNumberExceedMaximumException {
        courseForTest = new Course("CPSC",121,4,"HENN 202",
                "M W F 14:00 TO 15:00");
    }

    @BeforeEach
    public void setup () throws CourseCodeExceedMaximumException, CourseCreditExceedMaximumException, CourseNumberExceedMaximumException {
        courseList1 = new CourseList();
        courseList1.addCourse("CPSC",121, 4, "HENN 202", "M W F 14:00 TO 15:00");
        courseList1.addCourse("CPSC",210, 4, "SWNG 222", "M W F 12:00 TO 13:00");
        courseList1.addCourse("MATH",105, 3, "BUCH A102", "M W F 09:00 TO 10:00");
    }

    @Test
    public void testAddCourse() {
        assertEquals(3, courseList1.size());
    }

    @Test
    public void testRemove() {
        assertEquals(3, courseList1.size());
        courseList1.remove(0);

        assertEquals(2, courseList1.size());
    }

    @Test
    public void testRemoveCourse() {
        assertEquals(3, courseList1.size());

        assertEquals(-1, courseList1.removeCourse("PHIL", 220));

        assertEquals(0, courseList1.removeCourse("CPSC", 121));

        assertEquals(2, courseList1.removeCourse("MATH", 105));

        assertEquals(-1, courseList1.removeCourse("MATH", 104));

        assertEquals(-1, courseList1.removeCourse("PSYC", 105));
    }

    @Test
    public void testViewCourse() {
        assertEquals(3, courseList1.size());

        assertEquals(-1, courseList1.viewCourse("PHIL", 220));

        assertEquals(0, courseList1.viewCourse("CPSC", 121));

        assertEquals(2, courseList1.viewCourse("MATH", 105));

        assertEquals(-1, courseList1.viewCourse("MATH", 104));

        assertEquals(-1, courseList1.viewCourse("PSYC", 105));
    }

    @Test
    public void testTotalCredits() {
        assertEquals(3, courseList1.size());

        assertEquals(11, courseList1.totalCredits());
    }

    @Test
    public void testGetCourse () {
        courseToBeTested = courseList1.getCourse(0);
        assertEquals(courseForTest.getCourseCode(), courseToBeTested.getCourseCode());
        assertEquals(courseForTest.getCourseNumber(), courseToBeTested.getCourseNumber());
        assertEquals(courseForTest.getCourseCredits(), courseToBeTested.getCourseCredits());
        assertEquals(courseForTest.getCourseLocation(), courseToBeTested.getCourseLocation());
        assertEquals(courseForTest.getCourseTiming(), courseToBeTested.getCourseTiming());
    }
}