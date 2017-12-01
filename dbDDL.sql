drop database if exists db;
create database db;
use db;


CREATE TABLE RecipientSets (
	RecipientSetID INT auto_increment NOT NULL PRIMARY KEY,
	RecipientSetName VARCHAR(50) NOT NULL UNIQUE,
	Type VARCHAR(50) NOT NULL
);

--create index idx_RecipientSetID on RecipientSet(RecipientSetID);


CREATE TABLE Individuals (
	IndividualID INT auto_increment NOT NULL PRIMARY KEY,
	RecipientSetID INT NOT NULL,
	IndividualName VARCHAR(50) NOT NULL,
	FOREIGN KEY (RecipientSetID)
		REFERENCES RecipientSets (RecipientSetID)
);

--create index idx_IndividualsID on Individuals(IndividualsID);


CREATE TABLE Rules (
	RuleID INT auto_increment NOT NULL PRIMARY KEY,
	RecipientSetID INT NOT NULL,
	Info VARCHAR(50) NOT NULL,
	Regex VARCHAR(128) NOT NULL,
	FOREIGN KEY (RecipientSetID)
		REFERENCES RecipientSets (RecipientSetID)
);

--create index idx_RulesID on Rules(RulesID);


CREATE TABLE History (
	HistoryID INT auto_increment NOT NULL PRIMARY KEY,
	InfoShareEvent VARCHAR(128) NOT NULL,
	TimeInMillis BIGINT(19) NOT NULL
);

--create index idx_HistoryID on History(HistoryID);


CREATE TABLE Metadata (
	MetadataID INT auto_increment NOT NULL PRIMARY KEY,
	MetadataName VARCHAR(50) NOT NULL UNIQUE,
	Field INT(3) NOT NULL,
	Start INT(3) NOT NULL,
	End INT(3) NOT NULL
);

--create index idx_MetadataID on Metadata(MetadataID);
