-- Profile
INSERT INTO profile(firstname, lastname) VALUES ('Marco', 'Beckers');
INSERT INTO profile(firstname, lastname) VALUES ('Klaas', 'Deckers');

-- Goals
INSERT INTO goal (name, type, enddate) VALUES ('Leg muscle 4k', 'Legs', '1922-02-02');
INSERT INTO goal (name, type, enddate ) VALUES ('Arms muscle 4k', 'Legs', '1982-02-02');

-- Exercise

INSERT INTO exercise(name, description, musclegroup, vidlink, repetitions) VALUES ('PushUp', 'Set your hands on the ground', 'Arms', 'https://www.youtube.com/watch?v=THWq_scSIeo', 5);
INSERT INTO exercise(name, description, musclegroup, vidlink, repetitions) VALUES ('Squat', ' an exercise in which a standing person', 'Legs', 'https://www.youtube.com/watch?v=THWq_scSIeo', 10);
INSERT INTO exercise(name, description, musclegroup, vidlink, repetitions) VALUES ('PushUp', 'Set your hands on the ground', 'Arms', 'https://www.youtube.com/watch?v=THWq_scSIeo', 5);

-- Program
INSERT INTO program(name, type) VALUES ('Hatseflats' , 'lekker bewegen');
INSERT INTO program(name, type) VALUES ('adfsadf' , 'test');
INSERT INTO program(name, type) VALUES ('Hatsadsffadseflats' , 'test1');

