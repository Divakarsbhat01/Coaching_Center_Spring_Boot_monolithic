CREATE TABLE IF NOT EXISTS Course_Material
(
    course_material_id  NOT NULL PRIMARY KEY,
    FOREIGN KEY (course_id) REFERENCES Course(course_id)
    course_url  VARCHAR(100) NOT NULL
);