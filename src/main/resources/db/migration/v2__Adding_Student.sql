CREATE TABLE IF NOT EXISTS Student
(
    student_first_name   VARCHAR(50) NOT NULL,
    student_last_name    VARCHAR(50) NOT NULL,
    student_email        VARCHAR(50) NOT NULL,
    student_age       INT NOT NULL,
    student_id   NOT NULL PRIMARY KEY,
    FOREIGN KEY (parent_id) REFERENCES Parent(parent_id)
);