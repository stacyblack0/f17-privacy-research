drop database if exists db;
create database db;
use db;

-- drop table RecipientSets;
CREATE TABLE RecipientSets (
	RecipientSetID INT auto_increment NOT NULL PRIMARY KEY,
	RecipientSetName VARCHAR(50) NOT NULL UNIQUE,
	Type VARCHAR(50) NOT NULL
);

--create index idx_RecipientSetID on RecipientSet(RecipientSetID);



-- drop table Individuals;
CREATE TABLE Individuals (
	IndividualID INT auto_increment NOT NULL PRIMARY KEY,
    IndividualName VARCHAR(50) NOT NULL,
    FOREIGN KEY (RecipientSetID)
        REFERENCES RecipientSets (RecipientSetID)
);

--create index idx_IndividualsID on Individuals(IndividualsID);



-- drop table Rules;
CREATE TABLE Rules (
	RuleID INT auto_increment NOT NULL PRIMARY KEY,
    Info VARCHAR(50) NOT NULL,
    Regex VARCHAR(128) NOT NULL,
    FOREIGN KEY (RecipientSetID)
        REFERENCES RecipientSets (RecipientSetID)
);

--create index idx_RulesID on Rules(RulesID);



-- drop table History;
CREATE TABLE History (
	HistoryID INT auto_increment NOT NULL PRIMARY KEY,
    InfoShareEvent VARCHAR(128) NOT NULL,
    TimeInMillis BIGINT() NOT NULL
);

--create index idx_HistoryID on History(HistoryID);



-- drop table Metadata;
CREATE TABLE Metadata (
	MetadataID INT auto_increment NOT NULL PRIMARY KEY,
    MetadataName VARCHAR(50) NOT NULL UNIQUE,
    Field INT(3) NOT NULL,
    Start INT(3) NOT NULL,
    End INT(3) NOT NULL
);

--create index idx_MetadataID on Metadata(MetadataID);
