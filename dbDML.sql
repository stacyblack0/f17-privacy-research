use db;

INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('transportation','applications');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('colleagues','people');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('family','people');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('friends','people');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('cloud','services');

-- applications: transportation
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Uber',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Lyft',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('BSU Shuttle',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
-- people: colleagues
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Pam Beesly',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Jim Halpert',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Adela Jones',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Samantha Cho',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
-- people: family
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Rick Sanchez',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Summer Smith',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Beth Smith',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Jerry Smith',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
-- people: friends
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Adela Jones',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Catherine Zimmer',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('John Doe',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Joe Brown',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
-- services: cloud
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Google Drive',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='cloud' AND Type='services'));

INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','time=day', '',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','','.*(Adela Jones K location).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','','.*(Uber K location).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));

INSERT INTO History (InfoShareEvent,TimeInMillis) VALUES ('Adela Jones K location','14568465');
INSERT INTO History (InfoShareEvent,TimeInMillis) VALUES ('Rick Sanchez K location','24568455');

-- 11 = Calendar.HOUR_OF_DAY, 8 = 8AM, 16 = 4:59PM
INSERT INTO Metadata (MetadataName,Field,Start,End) VALUES ('business hours','11','8','16');
-- 7 = Calendar.DAY_OF_WEEK, 7 = Calendar.SATURDAY, 1 = Calendar.SUNDAY
INSERT INTO Metadata (MetadataName,Field,Start,End) VALUES ('weekend','7','7','1');
-- 11 = Calendar.HOUR_OF_DAY, 8 = 8AM, 19 = 7:59PM
INSERT INTO Metadata (MetadataName,Field,Start,End) VALUES ('day','11','8','19');
-- 11 = Calendar.HOUR_OF_DAY, 20 = 8PM, 7 = 7:59AM
INSERT INTO Metadata (MetadataName,Field,Start,End) VALUES ('night','11','20','7');

INSERT INTO Information (InformationName) VALUES ('location');
INSERT INTO Information (InformationName) VALUES ('health information');
INSERT INTO Information (InformationName) VALUES ('financial information');
INSERT INTO Information (InformationName) VALUES ('mutual friends');
