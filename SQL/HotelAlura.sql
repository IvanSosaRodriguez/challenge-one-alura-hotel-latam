CREATE SCHEMA HotelAlura;

USE HotelAlura;

CREATE TABLE Reservas(
ID_Reserva INT AUTO_INCREMENT PRIMARY KEY,
FechaEntrada DATE,
FechaSalida DATE,
Valor FLOAT,
FormaPago INT,
MetodoPago VARCHAR(30));

CREATE TABLE Huespedes(
ID_Huespedes INT AUTO_INCREMENT PRIMARY KEY,
Nombre VARCHAR(50),
Apellido VARCHAR(50),
FechaDeNacimiento DATE,
Nacionalidad VARCHAR(50),
Telefono DOUBLE,
ID_Reserva INT,
FOREIGN KEY (ID_Reserva ) REFERENCES Reservas(ID_Reserva));

