DROP TABLE Physician;
DROP TABLE Patient;
DROP TABLE Nurse;
DROP TABLE Department;
DROP TABLE Room;
DROP TABLE Test_Offered;


CREATE TABLE Department (
  DepartmentID VARCHAR(10) NOT NULL,
  Name VARCHAR(30) PRIMARY KEY NOT NULL
);

CREATE TABLE Room (
  RoomID INTEGER PRIMARY KEY NOT NULL,
  Type VARCHAR(20) NOT NULL,
  BlockNo INTEGER
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
  Doctor_in_charge_ID VARCHAR(30),
  Room_alloted INTEGER,
  Address VARCHAR(40) NOT NULL,
  Phone NUMERIC(10,0) NOT NULL,
  FOREIGN KEY(Room_alloted) REFERENCES Room,
  FOREIGN KEY(Doctor_in_charge_ID) REFERENCES Physician
);


CREATE TABLE Nurse (
  EmployeeID INTEGER PRIMARY KEY NOT NULL,
  Name VARCHAR(30) NOT NULL,
  Governs_Room INTEGER,
  FOREIGN KEY(Governs_Room) REFERENCES Room
);

CREATE TABLE Tests_Offered (
  TestID INTEGER PRIMARY KEY NOT NULL,
  TestName VARCHAR(30) NOT NULL,
  Offered_By VARCHAR(30),
  FOREIGN KEY(Offered_By) REFERENCES Department
);

/////////////////////////////////////////
