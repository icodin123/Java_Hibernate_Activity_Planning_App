CREATE TABLE users (
    name  VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255)
);

CREATE TABLE tasks (
    id SERIAL4 PRIMARY KEY,
    completed BOOL,
    date DATE,
    name  VARCHAR(255),
    user_name VARCHAR(255),
    CONSTRAINT fk_user_name
     FOREIGN key(user_name)
        REFERENCES users(name)
);