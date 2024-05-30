DROP TABLE IF EXISTS events;
CREATE TABLE events (
    name VARCHAR(255),
    date VARCHAR(255),
    location VARCHAR(255),
    description VARCHAR(255),
);

DROP TABLE IF EXISTS users;
CREATE TABLE users (
    username VARCHAR(255),
    password VARCHAR(255),
);

DROP TABLE IF EXISTS schedules;
CREATE TABLE schedules (
    activity VARCHAR(255),
    time VARCHAR(255),
);

DROP TABLE IF EXISTS attendees (
    name VARCHAR(255),
    email VARCHAR(255),
);

DROP TABLE IF EXISTS feedback;
CREATE TABLE feedback (
    attendeeName VARCHAR(255),
    comments VARCHAR(255),
    rating INT,
);