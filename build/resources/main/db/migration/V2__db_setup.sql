CREATE TABLE department (
  id UUID NOT NULL,
   subject VARCHAR(255),
   CONSTRAINT pk_department PRIMARY KEY (id)
);

ALTER TABLE department ADD CONSTRAINT uc_department_subject UNIQUE (subject);

CREATE TABLE marks (
  id UUID NOT NULL,
   mark BIGINT,
   CONSTRAINT pk_marks PRIMARY KEY (id)
);

CREATE TABLE student (
  id UUID NOT NULL,
   name VARCHAR(255),
   subject_id UUID,
   CONSTRAINT pk_student PRIMARY KEY (id)
);

CREATE TABLE student_marks_list (
  student_id UUID NOT NULL,
   marks_list_id UUID NOT NULL
);

ALTER TABLE student ADD CONSTRAINT uc_student_name UNIQUE (name);

ALTER TABLE student ADD CONSTRAINT FK_STUDENT_ON_SUBJECT FOREIGN KEY (subject_id) REFERENCES department (id);

ALTER TABLE student_marks_list ADD CONSTRAINT fk_stumarlis_on_marks FOREIGN KEY (marks_list_id) REFERENCES marks (id);

ALTER TABLE student_marks_list ADD CONSTRAINT fk_stumarlis_on_student FOREIGN KEY (student_id) REFERENCES student (id);