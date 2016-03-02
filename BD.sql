CREATE DATABASE Ventas


﻿CREATE TABLE Capturista (
	idCapturista integer PRIMARY KEY,
	Nombre varchar (15),
	AP varchar (15), 
	AM varchar (15)
	);
	
CREATE TABLE Ventas (
	idVentas integer PRIMARY KEY,
	Total_Bruto float,
	Total_Neto float,
	IVA float,
	Fecha date,
	idCapturista integer REFERENCES Capturista (idCapturista)
	);

