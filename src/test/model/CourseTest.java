package model;

import model.Course;
import static org.junit.jupiter.api.Assertions.*;

import model.exceptions.CourseCodeExceedMaximumException;
import model.exceptions.CourseCreditExceedMaximumException;
import model.exceptions.CourseNumberExceedMaximumException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Unit tests for the Course class
class CourseTest {
    public Course course1;
    public Course course2;
    public Course course3;
    public Course course4;

    // No exceptions expected in setup
    @BeforeEach
    public void setup () {
        try {
            course1 = new Course("math",105,3,"buch A102",
                    "m w f 09:00 to 10:00");
        } catch (CourseCodeExceedMaximumException | CourseNumberExceedMaximumException |
                CourseCreditExceedMaximumException e) {
            fail("Did not expect exception");
        }
        try {
            course2 = new Course("PHIL",220,3,"BUCH a103",
                    "m W f 10:00 to 11:00");
        } catch (CourseCodeExceedMaximumException | CourseNumberExceedMaximumException |
                CourseCreditExceedMaximumException e) {
            fail("Did not expect exception");
        }
        try {
            course3 = new Course("cpSC",210,4,"SWng 222",
                    "M W F 12:00 to 13:00");
        } catch (CourseCodeExceedMaximumException | CourseNumberExceedMaximumException |
                CourseCreditExceedMaximumException e) {
            fail("Did not expect exception");
        }
        try {
            course4 = new Course("CPsc",121,4,"henn 202",
                    "m w f 14:00 to 15:00");
        } catch (CourseCodeExceedMaximumException | CourseNumberExceedMaximumException |
                CourseCreditExceedMaximumException e) {
            fail("Did not expect exception");
        }
    }

    @Test
    public void testGetCourseCode() {
        assertEquals("MATH", course1.getCourseCode());
        assertEquals("PHIL", course2.getCourseCode());
        assertEquals("CPSC", course3.getCourseCode());
        assertEquals("CPSC", course4.getCourseCode());
    }

    @Test
    public void testGetCourseNumber() {
        assertEquals(105, course1.getCourseNumber());
        assertEquals(220, course2.getCourseNumber());
        assertEquals(210, course3.getCourseNumber());
        assertEquals(121, course4.getCourseNumber());

    }

    @Test
    public void testGetCourseCredits() {
        assertEquals(3, course1.getCourseCredits());
        assertEquals(3, course2.getCourseCredits());
        assertEquals(4, course3.getCourseCredits());
        assertEquals(4, course4.getCourseCredits());
    }

    @Test
    public void testGetCourseLocation() {
        assertEquals("BUCH A102", course1.getCourseLocation());
        assertEquals("BUCH A103", course2.getCourseLocation());
        assertEquals("SWNG 222", course3.getCourseLocation());
        assertEquals("HENN 202", course4.getCourseLocation());
    }

    @Test
    public void testGetCourseTiming() {
        assertEquals("M W F 09:00 TO 10:00", course1.getCourseTiming());
        assertEquals("M W F 10:00 TO 11:00", course2.getCourseTiming());
        assertEquals("M W F 12:00 TO 13:00", course3.getCourseTiming());
        assertEquals("M W F 14:00 TO 15:00", course4.getCourseTiming());
    }

    @Test
    public void testGetCourseName() {
        assertEquals("MATH 105", course1.getCourseName());
        assertEquals("PHIL 220", course2.getCourseName());
        assertEquals("CPSC 210", course3.getCourseName());
        assertEquals("CPSC 121", course4.getCourseName());
    }

    // Respective exceptions expected below
    @Test
    public void testCourseCodeExceedMaximumExceptionExpected() {
        try {
            Course testCourse = new Course("Cpscc",121,4,"henn 202",
                    "m w f 14:00 to 15:00");
        } catch (CourseCodeExceedMaximumException e) {
            // expected
        } catch (CourseCreditExceedMaximumException | CourseNumberExceedMaximumException e) {
            fail("Did not expect exception");
        }
    }

    @Test
    public void testCourseNumberExceedMaximumExceptionExpectedMoreThanThreeDigits() {
        try {
            Course testCourse = new Course("Cpsc",1211,4,"henn 202",
                    "m w f 14:00 to 15:00");
        } catch (CourseNumberExceedMaximumException e) {
            // expected
        } catch (CourseCreditExceedMaximumException | CourseCodeExceedMaximumException e) {
            fail("Did not expect exception");
        }
    }

    @Test
    public void testCourseNumberExceedMaximumExceptionExpectedLessThanThreeDigits() {
        try {
            Course testCourse = new Course("Cpsc",12,4,"henn 202",
                    "m w f 14:00 to 15:00");
        } catch (CourseNumberExceedMaximumException e) {
            // expected
        } catch (CourseCreditExceedMaximumException | CourseCodeExceedMaximumException e) {
            fail("Did not expect exception");
        }
    }

    @Test
    public void testCourseCreditExceedMaximumExceptionExpected() {
        try {
            Course testCourse = new Course("Cpsc",121,6,"henn 202",
                    "m w f 14:00 to 15:00");
        } catch (CourseCreditExceedMaximumException e) {
            // expected
        } catch (CourseCodeExceedMaximumException| CourseNumberExceedMaximumException e) {
            fail("Did not expect exception");
        }
    }
    }