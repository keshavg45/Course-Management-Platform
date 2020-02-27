package persistence;

import model.CourseList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class WriterTest {
    private static String TEST_WRITE_FILE = "./data/testWriteCourse.json";
    private CourseList testCourseList1;
    private CourseList testCourseList2;
    private Writer testWriter;

    @BeforeEach
    void runBefore() {
        testWriter = new Writer();
        testCourseList1 = new CourseList();
        testCourseList1.addCourse("MATH",105, 3, "BUCH A102", "M W F 09:00 TO 10:00");
        testCourseList1.addCourse("PHIL",220, 3, "BUCH A103", "M W F 10:00 TO 11:00");
        testCourseList1.addCourse("CPSC",210, 4, "SWNG 222", "M W F 12:00 TO 13:00");
        testCourseList1.addCourse("CPSC",121, 4, "HENN 202", "M W F 14:00 TO 15:00");
    }

    @Test
    void testSave() {
        try {
            testWriter.save(testCourseList1, TEST_WRITE_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Reader reader = new Reader();
            testCourseList2 = reader.load(TEST_WRITE_FILE);

            assertEquals("MATH", testCourseList2.getCourse(0).getCourseCode());
            assertEquals(105, testCourseList2.getCourse(0).getCourseNumber());
            assertEquals(3, testCourseList2.getCourse(0).getCourseCredits());
            assertEquals("BUCH A102", testCourseList2.getCourse(0).getCourseLocation());
            assertEquals("M W F 09:00 TO 10:00", testCourseList2.getCourse(0).getCourseTiming());

            assertEquals("CPSC", testCourseList2.getCourse(3).getCourseCode());
            assertEquals(121, testCourseList2.getCourse(3).getCourseNumber());
            assertEquals(4, testCourseList2.getCourse(3).getCourseCredits());
            assertEquals("HENN 202", testCourseList2.getCourse(3).getCourseLocation());
            assertEquals("M W F 14:00 TO 15:00", testCourseList2.getCourse(3).getCourseTiming());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}