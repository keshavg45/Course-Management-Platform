# Course Management Platform (CMP)

About
-----------------------------------------------------

I want to create a course management platform for students where they can 
store everything related to their course in one place. This means they can 
enter the semester from the following options - WT1 _(Winter Term 1)_, 
WT2 _(Winter Term 2)_, ST1 _(Summer Term 1)_, ST2 _(Summer Term 2)_. After 
entering the semester, students can add their **course code**, **course number**, 
number of **credits** the course is worth. There will also be an option to add
the **location** of the course and its **timing**. Currently, it is a very
simple project, but I wish to develop and expand it further to create something 
which will help many students.

This application will be used by students like myself. This project is 
particularly of interest to me because when I transitioned from high school
to university, it was a really big change for me. It felt like a lot at the
beginning but good planning and time management really helped me find my 
place here. Another reason why I want to pursue this project is that few of 
my courses have their details in one place whereas few others have their 
details elsewhere, like some of them use only one website to keep all the 
details whereas some have multiple websites for different things like 
submitting assignments, checking grades and other things. So, it gets somewhat
difficult to keep track of everything in your head and that's why I hope to 
create an application which removes these barriers and keeps everything in one 
place.

User Stories
-----------------------------------------------------

- As a user, I want to be able to enter my current semester.

- As a user, I want to be able to add a course to the list of courses in
 the current semester.

- As a user, I want to be able to view all my courses in the current semester.

- As a user, I want to be able to remove a course from the list of courses in
 the current semester.

- As a user, I want to be able to select a course and view its specific 
 details such as number of credits, location or timing.
 
 - As a user, I want to be able to see the total number of credits and total
 number of courses I am taking this semester.
 
 - As a user, I want to be able to save my course load of the semester that I
 entered when the application started to file (eg. WT1.json).
 
 - As a user, I want to be able to load my course load of the semester that I
 entered when the program starts from file.

Instructions for Grader
-----------------------------------------------------

- You can login with: 
    - _username:_ **keshavg**
    - _password:_ **qwerty**
    - incorrect username or password will return _**Invalid Credentials!**_


- You can choose the semester from the given four options: WT1, WT2, ST1 and ST2.
  On the basis of the choice, the header text, total credits and total number of
  courses are updated.
    
- You can add a course to the semester's course list by clicking on the
  _**Add**_ button which will open a pop up window which will allow the user
  to enter the details of a course.

- You can remove a course from the semester's course list by selecting a
  course and clicking on the _**Remove**_ button.

- You can view the details of a course in the semester's course list by
  selecting a course and clicking on the _**Details**_ button which will
  open a pop up window which will allow the user to view the details of a
  course.
  
- You can save any changes to the semester's course list by clicking on the
  _**Save**_ button. If the _**Save**_ button isn't clicked, no changes will
  be made to the course list.
  
- The semester's course list is dynamically loaded whenever a semester is
  selected and thus the application doesn't require a dedicated _**Load**_ button.
  
- You can return to the semester selection page by clicking on the _**Back**_
  button.
   
- You can locate my visual component by clicking on the _**View Logo**_ button on the
  bottom right which opens a new pop up window with the .jpg file of the logo/icon
  for my application.
  
- A short video is linked below showing the features of this application.

Phase 4: Task 2
----------------------------------------------------- 
- I made my Course class robust, specifically the Course constructor
 (_**/model/Course.java**_).
- It checks for 4 additional things now:
    - Invalid input type. (Unchecked)
    - Any input error in course code. (Checked)
    - Any input error in course number. (Checked)
    - Any input error in course credit. (Checked)
- The three exceptions are in the exceptions package (_**/model/exceptions/**_).
- The Course constructor throws all the exceptions when called by the CourseList
  method addCourse(...) and the method addCourse(...) further throws all the
  exceptions when called by addButtonClicked() method in AddPopUpController
  where it is ultimately caught and handled appropriately.
- The CourseTest class tests:
    - Unchecked exception in the setup() method.
    - Checked exceptions in their own respective methods.
    
Phase 4: Task 3
----------------------------------------------------- 
- I could not find any places with too much coupling or poor cohesion, I have
  posted on Piazza for help.
    
Extra Information
-----------------------------------------------------
- I initially wanted to add sounds on button click, like pressing the
 _**Log In**_ button will play a short sound but after spending quite a few hours
 trying to incorporate that feature I came to know that Amazon Corretto 8
 doesn't support JavaFX audio component thus I ended up using a simple
 image for the audiovisual requirement.
    - Source: https://piazza.com/class/k4erikupq2efg?cid=1240
    
- A short video is linked below showing the working of the application:
    - Video: https://drive.google.com/file/d/1if6eQo52HF4vMVOQbBnF5Bj9e0hphmW3/view?usp=sharing
    - Please watch the video in 1080p if possible.