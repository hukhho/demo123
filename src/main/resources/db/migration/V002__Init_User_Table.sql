-- Insert sample data into user table
INSERT INTO user (name, email, password) VALUES
                                             ('John Doe', 'john.doe@example.com', 'hashed_password_1'),
                                             ('Jane Smith', 'jane.smith@example.com', 'hashed_password_2');


-- Insert sample data into template table
INSERT INTO template (body) VALUES
                                ('Sample Template Body 1'),
                                ('Sample Template Body 2');


-- Insert sample data into experience table
INSERT INTO experience (company, role, duration, user_id) VALUES
                                                              ('TechCorp', 'Software Engineer', '2 years', 1),
                                                              ('WebWorks', 'Frontend Developer', '1 year', 2);

-- Insert sample data into education table
INSERT INTO education (college, gpa, user_id) VALUES
                                                  ('Tech University', '3.8', 1),
                                                  ('Web College', '3.7', 2);
