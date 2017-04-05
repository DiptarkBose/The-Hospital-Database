DROP TABLE Appointment;
DROP TABLE Nurse;
DROP TABLE Physician;
DROP TABLE Patient;
DROP TABLE Room;
DROP TABLE Block;
DROP TABLE Hospital_Department;


CREATE TABLE Hospital_Department (
  DepartmentID VARCHAR(10) NOT NULL,
  Name VARCHAR(30) PRIMARY KEY NOT NULL
);

CREATE TABLE Block(
 BlockCode INTEGER PRIMARY KEY NOT NULL,
 BlockName VARCHAR(20) NOT NULL
);

CREATE TABLE Room (
  RoomID INTEGER PRIMARY KEY NOT NULL,
  Type VARCHAR(20) NOT NULL,
  BlockCode INTEGER,
  FOREIGN KEY(BlockCode) REFERENCES Block
);

CREATE TABLE Physician (
  EmployeeID VARCHAR(20) PRIMARY KEY NOT NULL,
  Name VARCHAR(30) NOT NULL,
  Position VARCHAR(30) NOT NULL,
  Department_Name VARCHAR(30) NOT NULL,
  FOREIGN KEY(Department_Name) REFERENCES Department
); 

CREATE TABLE Patient (
  PatientID INTEGER PRIMARY KEY NOT NULL,
  Name VARCHAR(30) NOT NULL,
  Suffering_From VARCHAR(40),
  Room_alloted INTEGER,
  Address VARCHAR(40) NOT NULL,
  Phone NUMERIC(10,0) NOT NULL,
  FOREIGN KEY(Room_alloted) REFERENCES Room
);

CREATE TABLE Nurse (
  EmployeeID INTEGER PRIMARY KEY NOT NULL,
  Name VARCHAR(30) NOT NULL,
  Governs_Room INTEGER,
  FOREIGN KEY(Governs_Room) REFERENCES Room
);

CREATE TABLE Appointment(
 AppointmentID INTEGER PRIMARY KEY NOT NULL,
 PatientID INTEGER,
 EmployeeID VARCHAR(20),
 FOREIGN KEY(PatientID) REFERENCES Patient,
 FOREIGN KEY(EmployeeID) REFERENCES Physician
);

