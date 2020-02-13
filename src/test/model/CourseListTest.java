package model;

import model.Course;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Unit tests for the Course class
class CourseListTest {
    public CourseList courseList1;
    public Course course1 = new Course("MATH",105,3,"BUCH A102",
                "M W F 09:00 TO 10:00");

    @BeforeEach
    public void setup (){
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
    }

    @Test
    public void testTotalCredits() {
        assertEquals(3, courseList1.size());

        assertEquals(11, courseList1.totalCredits());
    }
}