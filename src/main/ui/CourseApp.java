package ui;

import model.CourseList;
import persistence.Reader;
import persistence.Writer;

import java.io.IOException;
import java.util.Scanner;

// Course Management Platform
public class CourseApp {
    public static String COURSE_FILE;
    public CourseList courseList;
    public int courseCount;
    public String semester;
    public Scanner sc;

    // EFFECTS: runs the course management platform
    public CourseApp() {
        runCourseApp();
    }

    // Menu idea taken from TellerApp: https://github.students.cs.ubc.ca/CPSC210/TellerApp
    // MODIFIES: this
    // EFFECTS: processes the user's input
    public void runCourseApp() {
        boolean keepGoing = true;
        courseList = new CourseList();
        sc = new Scanner(System.in);

        enterSemester();
        loadCourses();

        while (keepGoing) {
            displayMenu();
            String cmd = sc.next().toLowerCase();

            if (cmd.equals("q")) {
                keepGoing = false;
            } else {
                processMenu(cmd);
            }
        }
        System.out.println("\nThank you for using Course Management Platform (CMP)!");
    }

    // MODIFIES: semester
    // EFFECTS: lets the user enter their semester
    public void enterSemester() {
        System.out.print("\nEnter the semester (WT1/WT2/ST1/ST2): ");
        semester = sc.next().toUpperCase();
        COURSE_FILE =  "./data/" + semester + ".json";
    }

    // MODIFIES: this, courseCount
    public void doAddCourses() {
        printSemesterMessage();
        courseCount = sc.nextInt();
        for (int i = 0; i < courseCount; i++) {
            System.out.println();
            System.out.println("Enter the " + ordinal(i + 1) + " course");
            System.out.println();
            System.out.print("Enter Course Code (eg. CPSC): ");
            String cc = sc.next().toUpperCase();
            System.out.print("Enter Course Number (eg. 210): ");
            int cn = sc.nextInt();
            System.out.print("Enter Course Credits (eg. 4): ");
            int cred = sc.nextInt();
            sc.nextLine(); // to fix newline character error
            System.out.print("Enter Course Location (eg. SWNG 222): ");
            String cl = sc.nextLine().toUpperCase();
            System.out.print("Enter Course Timing (eg. M W F 12:00 TO 13:00): ");
            String ct = sc.nextLine().toUpperCase();
            courseList.addCourse(cc,cn,cred,cl,ct);
            System.out.println();
        }
    }

    // EFFECTS: prints the message taking in account number of courses
    public void printSemesterMessage() {
        if (courseList.size() == 0) {
            System.out.print("Enter the number of courses you want to add to " + semester + ": ");
        } else {
            System.out.print("Enter the number of new courses you want to add to " + semester + ": ");
        }
    }

    // EFFECTS: print all the courses in the list
    public void doListCourses() {
        System.out.println();
        if (courseList.size() == 0) {
            System.out.println("You have not added any courses yet!");
        } else {
            System.out.println("List of courses: ");
            for (int i = 0; i < courseList.size(); i++) {
                System.out.println(courseList.getCourse(i).getCourseCode() + " "
                        + courseList.getCourse(i).getCourseNumber());
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: removes course if found else prints appropriate message
    public void doRemoveCourse() {
        if (courseList.size() == 0) {
            System.out.println("You have not added any courses yet!");
        } else {
            System.out.println("Enter the course code: ");
            String cc = sc.next().toUpperCase();
            System.out.println("Enter the course number: ");
            int cn = sc.nextInt();
            int i = courseList.removeCourse(cc, cn);
            if (i != -1) {
                System.out.println("Successfully removed " + courseList.getCourse(i).getCourseCode()
                        + " " + courseList.getCourse(i).getCourseNumber() + "!");
                courseList.remove(i);
            } else {
                System.out.println("Invalid entry");
            }
        }
    }

    // EFFECTS: prints detail of the course if found else prints appropriate message
    public void doViewCourse() {
        if (courseList.size() == 0) {
            System.out.println("You have not added any courses yet!");
        } else {
            System.out.println("Enter the course code: ");
            String cc = sc.next().toUpperCase();
            System.out.println("Enter the course number: ");
            int cn = sc.nextInt();
            int i = courseList.viewCourse(cc,cn);
            if (i != -1) {
                System.out.println("Course Code: " + courseList.getCourse(i).getCourseCode());
                System.out.println("Course Number: " + courseList.getCourse(i).getCourseNumber());
                System.out.println("Course Credits: " + courseList.getCourse(i).getCourseCredits());
                System.out.println("Course Location: " + courseList.getCourse(i).getCourseLocation());
                System.out.println("Course Timing: " + courseList.getCourse(i).getCourseTiming());
            } else {
                System.out.println("Invalid entry");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: loads entered semester's course load from COURSE_FILE, if that file exists;
    // otherwise creates a new CourseList object
    public void loadCourses() {
        Reader reader = new Reader();
        try {
            courseList = reader.load(COURSE_FILE);
            System.out.println();
            System.out.println("CMP found " + semester + ".json in the /data folder so " + semester
                    + ".json was loaded!");
        } catch (IOException e) {
            init();
        }
    }

    // EFFECTS: saves entered semester's course load to COURSE_FILE
    public void saveCourses() {
        Writer writer = new Writer();
        try {
            writer.save(courseList, COURSE_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // MODIFIES: this
    // EFFECTS: constructs new CourseList
    public void init() {
        courseList = new CourseList();
        System.out.println();
        System.out.println("CMP couldn't find " + semester + ".json in the /data folder so it will create " + semester
                + ".json if you save it!");
    }

    // EFFECTS: print total credits and total number of courses if not empty else prints appropriate message
    public void doTotalCreditsCourses() {
        if (courseList.size() == 0) {
            System.out.println("You have not added any courses yet!");
        } else {
            System.out.println("Total Credits this semester: " + courseList.totalCredits());
            System.out.println("Number of courses this semester: " + courseList.size());
        }
    }

    // EFFECTS: displays menu of options to user
    public void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add courses");
        System.out.println("\tl -> view list of all courses");
        System.out.println("\tr -> remove a course");
        System.out.println("\tv -> view all details about a course");
        System.out.println("\ts -> save course load to file");
        System.out.println("\tt -> view total credits and number of courses this semester");
        System.out.println("\tq -> quit menu");
    }

    // MODIFIES: this
    // EFFECTS: displays menu of options to user
    public void processMenu(String command) {
        if (command.equals("a")) {
            doAddCourses();
        } else if (command.equals("l")) {
            doListCourses();
        } else if (command.equals("r")) {
            doRemoveCourse();
        } else if (command.equals("v")) {
            doViewCourse();
        } else if (command.equals("s")) {
            saveCourses();
        } else if (command.equals("t")) {
            doTotalCreditsCourses();
        } else {
            System.out.println("Invalid selection");
        }
    }

    // EFFECTS: converts number to ordinal form (eg 1 to 1st)
    // Taken from: https://stackoverflow.com/a/27204037
    public static String ordinal(int i) {
        int mod100 = i % 100;
        int mod10 = i % 10;
        if (mod10 == 1 && mod100 != 11) {
            return i + "st";
        } else if (mod10 == 2 && mod100 != 12) {
            return i + "nd";
        } else if (mod10 == 3 && mod100 != 13) {
            return i + "rd";
        } else {
            return i + "th";
        }
    }
}
