package persistence;

import static org.junit.jupiter.api.Assertions.*;

import model.CourseList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class ReaderTest {

    private static String TEST_READ_FILE = "./data/testReadCourse.json";
    private CourseList testCourseList1;
    private Reader testReader;

    @BeforeEach
    void runBefore() {
        testReader = new Reader();
        testCourseList1 = new CourseList();
    }

    @Test
    void testReadCourse() {
        try {
            testCourseList1 = testReader.load(TEST_READ_FILE);

            assertEquals("CPSC", testCourseList1.getCourse(0).getCourseCode());
            assertEquals(110, testCourseList1.getCourse(0).getCourseNumber());
            assertEquals(4, testCourseList1.getCourse(0).getCourseCredits());
            assertEquals("ESB 101", testCourseList1.getCourse(0).getCourseLocation());
            assertEquals("T T 15:30 TO 15:00", testCourseList1.getCourse(0).getCourseTiming());

            assertEquals("GRSJ", testCourseList1.getCourse(3).getCourseCode());
            assertEquals(224, testCourseList1.getCourse(3).getCourseNumber());
            assertEquals(3, testCourseList1.getCourse(3).getCourseCredits());
            assertEquals("BUCH D217", testCourseList1.getCourse(3).getCourseLocation());
            assertEquals("T T 14:00 TO 15:30", testCourseList1.getCourse(3).getCourseTiming());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testIOException() {
        try {
            testReader.load("./path/does/not/exist/testReadCourse.json");
        } catch (IOException e) {
            // expected
        }
    }
}
