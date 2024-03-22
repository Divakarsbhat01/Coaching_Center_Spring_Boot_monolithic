CREATE TABLE IF NOT EXISTS Student
(
    course_name   VARCHAR(50) NOT NULL,
    course_desc    VARCHAR(100) NOT NULL,
    course_credit  INT NOT NULL,
    course_id   NOT NULL PRIMARY KEY
);