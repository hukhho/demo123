CREATE TABLE user (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(255) NOT NULL,
                      email VARCHAR(255) UNIQUE NOT NULL,
                      password VARCHAR(255) NOT NULL
);

CREATE TABLE template (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          body TEXT
);

CREATE TABLE template_properties (
                                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                     name VARCHAR(255),
                                     list VARCHAR(255),
                                     imageName VARCHAR(255),
                                     syntaxKind VARCHAR(255),
                                     template_id BIGINT,
                                     FOREIGN KEY (template_id) REFERENCES template(id)
);

CREATE TABLE experience (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            company VARCHAR(255) NOT NULL,
                            role VARCHAR(255) NOT NULL,
                            duration VARCHAR(255) NOT NULL,
                            user_id BIGINT,
                            FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE education (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           college VARCHAR(255) NOT NULL,
                           gpa VARCHAR(10) NOT NULL,
                           user_id BIGINT,
                           FOREIGN KEY (user_id) REFERENCES user(id)
);
