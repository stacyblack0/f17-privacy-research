use db;

INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('transportation','applications');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('health','applications');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('banking','applications');
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('gaming','applications');
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
INSERT INTO RecipientSets (RecipientSetName,Type) VALUES ('cloud','services');

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
-- people: best friends
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Joe Brown',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
-- services: cloud
INSERT INTO Individuals (IndividualName,RecipientSetID) VALUES ('Google Drive',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='cloud' AND Type='services'));


-- insert rules!!
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','','.*(Uber K location).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('health information','','.*(Uber K health information).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('social security number','','.*(Uber K social security number).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('credit card number','','.*(Lyft K credit card number).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('banking history','','.*(Lyft K banking history).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('mutual friends','','.*(Lyft K mutual friends).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('personal planner','','.*(Lyft K personal planner).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('shopping history','','.*(BSU Shuttle K shopping history).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('home address','','.*(BSU Shuttle K home address).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('license plate number','','.*(BSU Shuttle K license plate number).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='transportation' AND Type='applications'));

INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','','.*(Fitbit K location).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('health information','','.*(Fitbit K health information).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('social security number','','.*(Fitbit K social security number).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('credit card number','','.*(Fitbit K credit card number).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('banking history','','.*(Fitbit K banking history).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('mutual friends','','.*(Fitbit K mutual friends).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('personal planner','','.*(Fitbit K personal planner).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('shopping history','','.*(Fitbit K shopping history).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('home address','','.*(Fitbit K home address).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('license plate number','','.*(Fitbit K license plate number).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='health' AND Type='applications'));

INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','','.*(MoneyTracker K location).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('health information','','.*(MoneyTracker K health information).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('social security number','','.*(MoneyTracker K social security number).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('credit card number','','.*(MoneyTracker K credit card number).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('banking history','','.*(MoneyTracker K banking history).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('mutual friends','','.*(MoneyTracker K mutual friends).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('personal planner','','.*(MoneyTracker K personal planner).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('shopping history','','.*(MoneyTracker K shopping history).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('home address','','.*(MoneyTracker K home address).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('license plate number','','.*(MoneyTracker K license plate number).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='banking' AND Type='applications'));

INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','','.*(Candy Crush K location).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('health information','','.*(Candy Crush K health information).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('social security number','','.*(Candy Crush K social security number).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('credit card number','','.*(Candy Crush K credit card number).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('banking history','','.*(Candy Crush K banking history).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('mutual friends','','.*(Candy Crush K mutual friends).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('personal planner','','.*(Candy Crush K personal planner).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('shopping history','','.*(Candy Crush K shopping history).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('home address','','.*(Candy Crush K home address).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('license plate number','','.*(Candy Crush K license plate number).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='gaming' AND Type='applications'));

INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','','.*(Facebook K location).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('health information','','.*(Facebook K health information).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('social security number','','.*(Facebook K social security number).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('credit card number','','.*(Facebook K credit card number).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('banking history','','.*(Facebook K banking history).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('mutual friends','','.*(Facebook K mutual friends).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('personal planner','','.*(Facebook K personal planner).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('shopping history','','.*(Facebook K shopping history).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('home address','','.*(Facebook K home address).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('license plate number','','.*(Facebook K license plate number).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='social media' AND Type='applications'));

INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','time=business hours','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('health information','time=business hours','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('social security number','time=business hours','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('credit card number','time=business hours','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('banking history','time=business hours','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('mutual friends','time=business hours','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('personal planner','time=business hours','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('shopping history','time=business hours','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('home address','time=business hours','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('license plate number','time=business hours','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='colleagues' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('health information','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('social security number','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('credit card number','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('banking history','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('mutual friends','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('personal planner','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('shopping history','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('home address','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('license plate number','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='family' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('health information','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('social security number','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('credit card number','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('banking history','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('mutual friends','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('personal planner','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('shopping history','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('home address','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('license plate number','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='immediate family' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('health information','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('social security number','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('credit card number','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('banking history','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('mutual friends','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('personal planner','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('shopping history','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('home address','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('license plate number','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='extended family' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('health information','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('social security number','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('credit card number','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('banking history','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('mutual friends','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('personal planner','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('shopping history','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('home address','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('license plate number','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='acquaintances' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('health information','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('social security number','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('credit card number','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('banking history','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('mutual friends','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('personal planner','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('shopping history','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('home address','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('license plate number','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='friends' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('health information','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('social security number','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('credit card number','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('banking history','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('mutual friends','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('personal planner','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('shopping history','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('home address','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('license plate number','time=day','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='instagram friends' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','time=night','.*(Adela Jones K location).*',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('health information','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('social security number','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('credit card number','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('banking history','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('mutual friends','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('personal planner','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('shopping history','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('home address','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('license plate number','time=night','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='close friends' AND Type='people'));

INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('location','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('health information','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('social security number','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('credit card number','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('banking history','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('mutual friends','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('personal planner','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('shopping history','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('home address','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));
INSERT INTO Rules (Info,Conditions,Regex,RecipientSetID) VALUES ('license plate number','time=weekend','',
	(SELECT RecipientSetID FROM RecipientSets WHERE RecipientSetName='best friends' AND Type='people'));


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
