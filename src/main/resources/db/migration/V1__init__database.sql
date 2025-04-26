CREATE TABLE IF NOT EXISTS Parent
(
    parent_first_name   VARCHAR(50) NOT NULL,
    parent_last_name    VARCHAR(50) NOT NULL,
    parent_email        VARCHAR(50) NOT NULL,
    parent_mobile       VARCHAR(50) NOT NULL,
    parent_id           INTEGER NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Student
(
    student_first_name   VARCHAR(50) NOT NULL,
    student_last_name    VARCHAR(50) NOT NULL,
    email_id        VARCHAR(50) NOT NULL,
    student_age          INT NOT NULL,
    student_id           INTEGER NOT NULL PRIMARY KEY,
    parent_id            INTEGER NOT NULL,
    FOREIGN KEY (parent_id) REFERENCES Parent(parent_id)
);

CREATE TABLE IF NOT EXISTS Course
(
    course_name   VARCHAR(50) NOT NULL,
    course_desc    VARCHAR(100) NOT NULL,
    course_credit  INT NOT NULL,
    course_id   INTEGER NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Teacher
(
    teacher_first_name   VARCHAR(50) NOT NULL,
    teacher_last_name    VARCHAR(50) NOT NULL,
    teacher_email        VARCHAR(50) NOT NULL,
    teacher_id   INTEGER NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Course_Material
(
    course_material_id  INT NOT NULL PRIMARY KEY,
    course_id            INTEGER NOT NULL,
    course_url  VARCHAR(100) NOT NULL,
    FOREIGN KEY (course_id) REFERENCES Course(course_id)
);

CREATE TABLE IF NOT EXISTS Student_Course
(
    scID INT NOT NULL PRIMARY KEY,
    student_id            INTEGER NOT NULL,
    course_id            INTEGER NOT NULL,
    FOREIGN KEY (student_id) REFERENCES Student(student_id),
    FOREIGN KEY (course_id) REFERENCES Course(course_id)
);

CREATE TABLE IF NOT EXISTS Teacher_Course
(
   tcID INT NOT NULL PRIMARY KEY,
   teacher_id           INTEGER NOT NULL,
   course_id            INTEGER NOT NULL,
   FOREIGN KEY (teacher_id) REFERENCES Teacher(teacher_id),
   FOREIGN KEY (course_id) REFERENCES Course(course_id)
);

create table course_material_sequence (next_val bigint);
insert into course_material_sequence values ( 1 );

create table course_sequence (next_val bigint);
insert into course_sequence values ( 1 );

create table parent_sequence (next_val bigint);
insert into parent_sequence values ( 1 );

create table studentcsequence (next_val bigint);
insert into studentcsequence values ( 1 );

create table student_sequence (next_val bigint);
insert into student_sequence values ( 1 );

create table teachercsequence (next_val bigint);
insert into teachercsequence values ( 1 );

create table teacher_sequence (next_val bigint);
insert into teacher_sequence values ( 1 );