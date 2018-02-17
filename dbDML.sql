use db;

INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('transportation','applications');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('health','applications');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('banking','applications');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('gaming','applications');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('shopping','applications');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('social media','applications');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('colleagues','people');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('family','people');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('immediate family','people');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('extended family','people');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('acquaintances','people');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('friends','people');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('instagram friends','people');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('close friends','people');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('best friends','people');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('google services','services');

-- applications: transportation
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Uber',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Lyft',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('BSU Shuttle',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
-- applications: health
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Fitbit',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
-- applications: banking
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('MoneyTracker',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
-- applications: gaming
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Candy Crush',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
-- applications: shopping
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Amazon',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));
-- applications: social media
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Facebook',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
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
-- people: immediate family
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Summer Smith',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Beth Smith',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
-- people: extended family
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Rick Sanchez',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Jerry Smith',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
-- people: acquaintances
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Jane Doe',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));
-- people: friends
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Adela Jones',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Catherine Zimmer',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('John Doe',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Joe Brown',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
-- people: instagram friends
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Catherine Zimmer',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));
-- people: close friends
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('John Doe',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Adela Jones',
    (SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
-- people: best friends
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Joe Brown',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
-- services: cloud
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Google Drive',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Gmail',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('YouTube',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Google Docs',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));


-- insert rules!!
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','-1','-1','0','2','6','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('social security number','-1','-1','0','-1','-1','0','.*(transportation K location).*(transportation K social security number).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('credit card number','-1','-1','0','-1','-1','0','.*(transportation K location).*(transportation K credit card number).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('personal info','-1','-1','0','-1','-1','0','.*(transportation K location).*(transportation K personal info).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','800','1959','0','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));

INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','800','1959','0','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('health information','-1','-1','0','-1','-1','0','.*(health K location).*(health K health information).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('credit card number','-1','-1','0','-1','-1','0','.*(health K location).*(health K credit card number).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('personal info','-1','-1','0','-1','-1','0','.*(health K location).*(health K personal info).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));

INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('social security number','-1','-1','0','-1','-1','0','','year','3','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('credit card number','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('financial','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('shopping history','-1','-1','0','-1','-1','0','.*(banking K credit card number).*(banking K shopping history).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','-1','-1','0','-1','-1','0','.*(banking K credit card number).*(banking K home address).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','-1','-1','0','7','1','1','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));

INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','800','1959','0','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('credit card number','-1','-1','0','-1','-1','0','.*(gaming K location).*(gaming K credit card number).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('photos','-1','-1','0','7','1','1','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));

INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('credit card number','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('shopping history','-1','-1','0','-1','-1','0','.*(shopping K credit card number).*(shopping K shopping history).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','-1','-1','0','-1','-1','0','.*(shopping K credit card number).*(shopping K home address).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('photos','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','-1','-1','0','7','1','1','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));

INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','-1','-1','0','7','1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('credit card number','-1','-1','0','-1','-1','0','.*(social media K location).*(social media K credit card number).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('photos','800','1659','1','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('personal info','800','1959','0','-1','-1','0','','','0','g',
  (SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','-1','-1','0','-1','-1','0','.*(social media K location).*(social media K home address).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','-1','-1','0','7','1','1','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));

INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','700','1759','0','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('calendar','700','1759','0','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','-1','-1','0','7','1','1','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));

INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','-1','-1','0','7','1','1','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('photos','-1','-1','0','7','1','1','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));

INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('health information','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('social security number','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('credit card number','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('financial','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('photos','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('personal info','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('shopping history','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('license plate number','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));

INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','-1','-1','0','7','1','1','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('photos','-1','-1','0','7','1','1','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));

INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','800','1959','0','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));

INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('photos','800','1959','0','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));

INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','800','1959','0','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('photos','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));

INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','-1','-1','0','7','1','1','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('photos','-1','-1','0','7','1','1','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('personal info','-1','-1','0','7','1','1','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','-1','-1','0','7','1','1','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));

INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('health information','-1','-1','0','7','1','1','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('photos','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('personal info','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));

INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','800','1659','0','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('credit card number','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('financial','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('photos','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('personal info','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('shopping history','-1','-1','0','-1','-1','0','.*(google services K credit card number).*(google services K shopping history).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,TimeStart,TimeEnd,TimeNegation,DayStart,DayEnd,DayNegation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','000','2359','0','1','7','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));


INSERT INTO History (IndividualShare,GroupShare,TimeInMillis) VALUES ('Adela Jones K location','friends K location','14568465');
INSERT INTO History (IndividualShare,GroupShare,TimeInMillis) VALUES ('Rick Sanchez K location','extended family K location','24568455');

-- 11 = Calendar.HOUR_OF_DAY
INSERT INTO Metadata (MetadataName,Field,Start,End) VALUES ('business hours','11','800','1659');
-- 7 = Calendar.DAY_OF_WEEK, 7 = Calendar.SATURDAY, 1 = Calendar.SUNDAY
INSERT INTO Metadata (MetadataName,Field,Start,End) VALUES ('weekend','7','7','1');
-- 11 = Calendar.HOUR_OF_DAY
INSERT INTO Metadata (MetadataName,Field,Start,End) VALUES ('day','11','800','1959');
-- 11 = Calendar.HOUR_OF_DAY
INSERT INTO Metadata (MetadataName,Field,Start,End) VALUES ('night','11','1700','2359');

INSERT INTO Information (InformationName) VALUES ('location');
INSERT INTO Information (InformationName) VALUES ('health information');
INSERT INTO Information (InformationName) VALUES ('social security number');
INSERT INTO Information (InformationName) VALUES ('credit card number');
INSERT INTO Information (InformationName) VALUES ('financial');
INSERT INTO Information (InformationName) VALUES ('photos');
INSERT INTO Information (InformationName) VALUES ('personal info');
INSERT INTO Information (InformationName) VALUES ('shopping history');
INSERT INTO Information (InformationName) VALUES ('home address');
INSERT INTO Information (InformationName) VALUES ('license plate number');
INSERT INTO Information (InformationName) VALUES ('calendar');
INSERT INTO Information (InformationName) VALUES ('phone number');
INSERT INTO Information (InformationName) VALUES ('email address');

INSERT INTO TrackedInfo (InformationID) VALUES ((SELECT InformationID FROM Information WHERE InformationName="location"));
