CREATE TABLE Employees (
    EmployeeID VARCHAR(255) PRIMARY KEY,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    Role VARCHAR(50),
    Email VARCHAR(255),
    PhoneNumber VARCHAR(50),
    AssignedFlightID VARCHAR(255) -- foreign key to Flights
);

CREATE TABLE Flights (
    FlightID VARCHAR(255) PRIMARY KEY,
    Origin VARCHAR(255),
    Destination VARCHAR(255),
    Distance DOUBLE
);

CREATE TABLE Passengers (
    PassengerID VARCHAR(255) PRIMARY KEY,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    DateOfBirth DATE,
    PassportNumber VARCHAR(255),
    Email VARCHAR(255),
    PhoneNumber VARCHAR(50)
);
