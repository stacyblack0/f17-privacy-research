drop database if exists db;
create database db;
use db;


CREATE TABLE RecipientSets (
	RecipientSetID INT auto_increment NOT NULL PRIMARY KEY,
	RecipientSetName VARCHAR(50) NOT NULL UNIQUE,
	Type VARCHAR(50) NOT NULL
);


CREATE TABLE Individuals (
	IndividualID INT auto_increment NOT NULL PRIMARY KEY,
	RecipientSetID INT NOT NULL,
	IndividualName VARCHAR(50) NOT NULL,
	FOREIGN KEY (RecipientSetID)
		REFERENCES RecipientSets (RecipientSetID)
);


CREATE TABLE Rules (
	RuleID INT auto_increment NOT NULL PRIMARY KEY,
	RecipientSetID INT NOT NULL,
	Info VARCHAR(50) NOT NULL,
	TimeStart INT(5),
	TimeEnd INT(5),
	TimeNegation BOOLEAN,
	DayStart INT(5),
	DayEnd INT(5),
	DayNegation BOOLEAN,
	Regex VARCHAR(256),
	RegexInterval VARCHAR(50),
	RegexFrequency INT,
	Scope VARCHAR(1) NOT NULL,
	FOREIGN KEY (RecipientSetID)
		REFERENCES RecipientSets (RecipientSetID)
);


CREATE TABLE History (
	HistoryID INT auto_increment NOT NULL PRIMARY KEY,
	IndividualShare VARCHAR(128) NOT NULL,
	GroupShare VARCHAR(128) NOT NULL,
	TimeInMillis BIGINT(19) NOT NULL
);


CREATE TABLE Metadata (
	MetadataID INT auto_increment NOT NULL PRIMARY KEY,
	MetadataName VARCHAR(50) NOT NULL UNIQUE,
	Field INT(3) NOT NULL,
	Start INT(3) NOT NULL,
	End INT(3) NOT NULL
);


CREATE TABLE Information (
	InformationID INT auto_increment NOT NULL PRIMARY KEY,
	InformationName VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE Priorities (
	PriorityID INT auto_increment NOT NULL PRIMARY KEY,
	RuleID INT NOT NULL,
	PriorityValue INT NOT NULL,
	FOREIGN KEY (RuleID)
		REFERENCES Rules (RuleID)
);
