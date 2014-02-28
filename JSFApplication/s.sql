CREATE TABLE APP.RUser (
 id_user varchar(255) NOT NULL,
 password varchar(255) NOT NULL,
 PRIMARY KEY (id_user)
);


INSERT INTO APP.RUser VALUES('admin','202cb962ac59075b964b07152d234b70');


INSERT INTO APP.RUser VALUES('moder1','moder1pass');
INSERT INTO APP.RUser VALUES('guest1','guest1pass');
INSERT INTO APP.RUser VALUES('guest2','guest2pass');
INSERT INTO APP.RUser VALUES('moder2','moder2pass');
 
CREATE TABLE APP.RUser_Group (
 id_group varchar(20) NOT NULL,
 id_user varchar(255) NOT NULL
);
 
INSERT INTO APP.RUser_Group VALUES('admin','admin');
INSERT INTO APP.RUser_Group VALUES('moder','moder1');
INSERT INTO APP.RUser_Group VALUES('moder','moder2');
INSERT INTO APP.RUser_Group VALUES('guest','guest1');
INSERT INTO APP.RUser_Group VALUES('guest','guest2');