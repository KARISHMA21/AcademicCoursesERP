create table employee(
	employeeId integer,
	name varchar(30),
	department varchar(30),
	email varchar(50),
	password varchar(10),
	
	
	constraint pk_employee PRIMARY KEY (employeeId)
	
	
);

insert into employee(employeename,department,email,password) values
("karishma chauhan","admin","karishma.chauhan@iiitb.ac.in",123),
("Chandrashekar Ramanathan","faculty","Chandrashekar.Ramanathan@iiitb.ac.in",123),
("Neelam Sinha","faculty","Neelam.Sinha@iiitb.ac.in",123),
("Sachit Rao","faculty","Sachit.Rao@iiitb.ac.in",123),
("Priyanka Das","faculty","Priyanka.Das@iiitb.ac.in",123)



insert into employee(employeename,department,email,password) values
("B Thangaraju","faculty","B.Thangaraju@iiitb.ac.in",123),
("Muralidhara","faculty","Muralidhara@iiitb.ac.in",123)
;
 

create table course(
	id integer,
	courseCode varchar(30) NOT NULL,
	courseName varchar(30) NOT NULL,
	description varchar(500),
	year smallint NOT NULL,
	term smallint NOT NULL,
	credits smallint NOT NULL,
	capacity smallint NOT NULL,
	
	constraint pk_course PRIMARY KEY (id)
);


insert into course(capacity,courseCode,credits,description,courseName,term,year,facultyid) values
(150,"MT10",2,"will teach you the basics of Python, data operations, conditional statements","Python",1,1,4),
(150,"AI10",4," mathematical foundations of basic machine learn- ing concepts","Maths for Machine Learning ",1,1,5),
(150,"AI11",4,"Predictive Analytics using Python, Machine Learning, Data Visualization","Machine Learning ",1,1,3),
(150,"CS12",2,"provides the knowledge and skills of system programming and concept such as File, Process, Signals and IPC are compatible with the UNIX variants","Software Systems ",1,1,6),
(150,"CS13",2,"introduces the elements of enterprise software development with focus on web app development","Enterprise Software",1,1,3),
(180,"CS11",4,"Covers data structures and algorithms design techniques etc", "Algorithms",1,1,7)
;

insert into Course_Prerequisite(Course_id,prerequisite_id) values(6,4),(6,5),(8,4);

