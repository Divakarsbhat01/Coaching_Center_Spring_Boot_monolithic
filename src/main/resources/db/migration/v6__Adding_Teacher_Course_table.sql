CREATE TABLE IF NOT EXISTS Teacher_Course
(
   tcID INT NOT NULL PRIMARY KEY,
   FOREIGN KEY (teacherId) REFERENCES Teacher(teacher_id),
   FOREIGN KEY (courseId) REFERENCES Course(course_id)
);