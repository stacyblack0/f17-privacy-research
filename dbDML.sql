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
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Jerry Smith',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
-- people: extended family
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Rick Sanchez',
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
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('location','(day > 6 or day < 2)','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('social security number','','.*(Uber K location).*(Uber K social security number).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('credit card number','','.*(Lyft K credit card number).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('personal planner','','.*(Lyft K personal planner).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('home address','','.*(BSU Shuttle K home address).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('phone number','','.*(BSU Shuttle K phone number).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('email address','','.*(BSU Shuttle K email address).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));

INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('location','','.*(Fitbit K location).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('health information','','.*(Fitbit K health information).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('credit card number','','.*(Fitbit K credit card number).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('mutual friends','','.*(Fitbit K mutual friends).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('personal planner','','.*(Fitbit K personal planner).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('email address','','.*(Fitbit K email address).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));

INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('social security number','','.*(MoneyTracker K social security number).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('credit card number','','.*(MoneyTracker K credit card number).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('banking history','','.*(MoneyTracker K banking history).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('shopping history','','.*(MoneyTracker K shopping history).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('home address','','.*(MoneyTracker K home address).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('phone number','','.*(MoneyTracker K phone number).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('email address','','.*(MoneyTracker K email address).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));

INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('credit card number','','.*(Candy Crush K credit card number).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('mutual friends','','.*(Candy Crush K mutual friends).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('email address','','.*(Candy Crush K email address).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));

INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('credit card number','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('shopping history','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('home address','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('phone number','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('email address','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));

INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('location','','.*(Facebook K location).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('credit card number','','.*(Facebook K credit card number).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('mutual friends','','.*(Facebook K mutual friends).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('personal planner','','.*(Facebook K personal planner).*','g',
  (SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('home address','','.*(Facebook K home address).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('phone number','','.*(Facebook K phone number).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('email address','','.*(Facebook K email address).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));

INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('location','(time > 7 and time < 17)','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('work schedule','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('phone number','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('email address','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('location','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('mutual friends','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('home address','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('phone number','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('email address','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('location','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('health information','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('social security number','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('credit card number','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('banking history','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('mutual friends','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('personal planner','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('shopping history','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('home address','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('license plate number','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('phone number','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('email address','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('location','(day > 6 or day < 2)','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('mutual friends','(day > 6 or day < 2)','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('home address','(time > 19 or time < 8)','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('phone number','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('email address','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('location','(time > 7 and time < 17)','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('email address','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('mutual friends','(time > 19 and time < 8)','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('phone number','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('email address','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('location','(time > 7 and time < 17)','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('mutual friends','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('email address','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('location','true','.*(Adela Jones K location).*','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('mutual friends','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('personal planner','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('home address','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('phone number','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('email address','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('location','(day > 6 or day < 2)','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('health information','(day > 6 or day < 2)','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('mutual friends','(day > 6 or day < 2)','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('personal planner','(day > 6 or day < 2)','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('home address','(day > 6 or day < 2)','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('phone number','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('email address','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('location','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('credit card number','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('banking history','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('mutual friends','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('personal planner','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('shopping history','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('home address','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('phone number','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,Conditions,Regex,Scope,RecipientSetID) VALUES ('email address','true','','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));


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
INSERT INTO Information (InformationName) VALUES ('social security number');
INSERT INTO Information (InformationName) VALUES ('credit card number');
INSERT INTO Information (InformationName) VALUES ('banking history');
INSERT INTO Information (InformationName) VALUES ('mutual friends');
INSERT INTO Information (InformationName) VALUES ('personal planner');
INSERT INTO Information (InformationName) VALUES ('shopping history');
INSERT INTO Information (InformationName) VALUES ('home address');
INSERT INTO Information (InformationName) VALUES ('license plate number');
INSERT INTO Information (InformationName) VALUES ('work schedule');
INSERT INTO Information (InformationName) VALUES ('phone number');
INSERT INTO Information (InformationName) VALUES ('email address');
