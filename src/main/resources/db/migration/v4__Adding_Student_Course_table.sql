CREATE TABLE IF NOT EXISTS Student_Course
(
    scID INT NOT NULL PRIMARY KEY,
    FOREIGN KEY (studentId) REFERENCES Student(student_id),
    FOREIGN KEY (courseId) REFERENCES Course(course_id)
);