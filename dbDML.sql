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
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','day','6','2','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('social security number','','-1','-1','0','.*(Uber K location).*(Uber K social security number).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('credit card number','','-1','-1','0','.*(Lyft K credit card number).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('personal planner','','-1','-1','0','.*(Lyft K personal planner).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','','-1','-1','0','.*(BSU Shuttle K home address).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','','-1','-1','0','.*(BSU Shuttle K phone number).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','','-1','-1','0','.*(BSU Shuttle K email address).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));

INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','','-1','-1','0','.*(Fitbit K location).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('health information','','-1','-1','0','.*(Fitbit K health information).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('credit card number','','-1','-1','0','.*(Fitbit K credit card number).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('mutual friends','','-1','-1','0','.*(Fitbit K mutual friends).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('personal planner','','-1','-1','0','.*(Fitbit K personal planner).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','','-1','-1','0','.*(Fitbit K email address).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));

INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('social security number','','-1','-1','0','.*(MoneyTracker K social security number).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('credit card number','','-1','-1','0','.*(MoneyTracker K credit card number).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('banking history','','-1','-1','0','.*(MoneyTracker K banking history).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('shopping history','','-1','-1','0','.*(MoneyTracker K shopping history).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','','-1','-1','0','.*(MoneyTracker K home address).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','','-1','-1','0','.*(MoneyTracker K phone number).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','','-1','-1','0','.*(MoneyTracker K email address).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));

INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('credit card number','','-1','-1','0','.*(Candy Crush K credit card number).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('mutual friends','','-1','-1','0','.*(Candy Crush K mutual friends).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','','-1','-1','0','.*(Candy Crush K email address).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));

INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('credit card number','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('shopping history','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='shopping' AND Type='applications'));

INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','','-1','-1','0','.*(Facebook K location).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('credit card number','','-1','-1','0','.*(Facebook K credit card number).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('mutual friends','','-1','-1','0','.*(Facebook K mutual friends).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('personal planner','','-1','-1','0','.*(Facebook K personal planner).*','','0','g',
  (SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','','-1','-1','0','.*(Facebook K home address).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','','-1','-1','0','.*(Facebook K phone number).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','','-1','-1','0','.*(Facebook K email address).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));

INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','time','7','17','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('work schedule','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));

INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('mutual friends','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));

INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('health information','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('social security number','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('credit card number','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('banking history','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('mutual friends','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('personal planner','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('shopping history','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('license plate number','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));

INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','day','6','2','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('mutual friends','day','6','2','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','time','19','8','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));

INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','time','7','17','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));

INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('mutual friends','time','19','8','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));

INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','time','7','17','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('mutual friends','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));

INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','','-1','-1','0','.*(Adela Jones K location).*','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('mutual friends','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('personal planner','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));

INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','day','6','2','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('health information','day','6','2','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('mutual friends','day','6','2','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('personal planner','day','6','2','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','day','6','2','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));

INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('location','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('credit card number','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('banking history','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('mutual friends','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('personal planner','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('shopping history','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('home address','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('phone number','true','-1','-1','0','','','0','g',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='google services' AND Type='services'));
INSERT INTO Rules (Info,ConditionType,ConditionStart,ConditionEnd,Negation,Regex,RegexInterval,RegexFrequency,Scope,RecipientSetID)
	VALUES ('email address','true','-1','-1','0','','','0','g',
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
