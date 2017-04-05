INSERT INTO Department VALUES(1,'General Medicine');
INSERT INTO Department VALUES(2,'Surgery');
INSERT INTO Department VALUES(3,'Psychiatry');

INSERT INTO Block VALUES(1,'Sigmun Freud');
INSERT INTO Block VALUES(2,'Ron Paul');

INSERT INTO Room VALUES(101,'Single',1);
INSERT INTO Room VALUES(102,'Single',1);
INSERT INTO Room VALUES(103,'Single',1);
INSERT INTO Room VALUES(201,'Single',2);
INSERT INTO Room VALUES(202,'Single',2);

INSERT INTO Physician VALUES(1,'John Dorian','Staff Internist','General Medicine');
INSERT INTO Physician VALUES(2,'Elliot Reid','Attending Physician','General Medicine');
INSERT INTO Physician VALUES(3,'Christopher Turk','Surgical Attending Physician','Surgery');
INSERT INTO Physician VALUES(4,'Percival Cox','Senior Attending Physician','Surgery');
INSERT INTO Physician VALUES(5,'Bob Kelso','Head Chief of Medicine','General Medicine');
INSERT INTO Physician VALUES(6,'Todd Quinlan','Surgical Attending Physician','Surgery');
INSERT INTO Physician VALUES(7,'John Wen','Surgical Attending Physician','Surgery');
INSERT INTO Physician VALUES(8,'Keith Dudemeister','MD Resident','General Medicine');
INSERT INTO Physician VALUES(9,'Molly Clock','Attending Psychiatrist','Psychiatry');

INSERT INTO Patient VALUES(101,'John Smith','Tuberculosis',101,'42 Foobar Lane',555-0256);
INSERT INTO Patient VALUES(102,'Grace Ritchie','Shoulder Injury',201,'37 Snafu Drive',555-0512);
INSERT INTO Patient VALUES(103,'Random J. Patient','Common Cold',101, '123 Omgbbq Street',555-1204);
INSERT INTO Patient VALUES(104,'Dennis Doe','Depression',103, '230-B Foobaz Avenue',555-2048);
INSERT INTO Patient VALUES(105,'James Bond','Constipation',202,'134 Privet Drive',555-0234);

INSERT INTO Nurse VALUES(101,'Carla Espinosa',101);
INSERT INTO Nurse VALUES(102,'Laverne Roberts',202);
INSERT INTO Nurse VALUES(103,'Paul Flowers',103);
INSERT INTO Nurse VALUES(104,'Nishant Bhat',102);

INSERT INTO Appointment VALUES(1,101,2);
INSERT INTO Appointment VALUES(2,104,9);
INSERT INTO Appointment VALUES(3,103,8);
INSERT INTO Appointment VALUES(4,102,6);
INSERT INTO Appointment VALUES(5,105,4);

