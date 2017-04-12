insert ignore into sec_group(GROUPNAME,GROUPDESCRIPTION) values ('CUSTOMERS','This group has customers.');
insert ignore into sec_group(GROUPNAME,GROUPDESCRIPTION) values ('ADMINISTRATORS','This group has administrators.');

insert ignore into sec_user(USERNAME,PASSWORD) values ('customer1', SHA2('customer1', 256));
insert ignore into sec_user(USERNAME,PASSWORD) values ('customer2', SHA2('customer2', 256));
insert ignore into sec_user(USERNAME,PASSWORD) values ('customer3', SHA2('customer3', 256));
insert ignore into sec_user(USERNAME,PASSWORD) values ('admin1', SHA2('admin1', 256));
insert ignore into sec_user(USERNAME,PASSWORD) values ('admin2', SHA2('admin2', 256));

insert ignore into User_Groups(USERNAME,GROUPNAME) values ('customer1','CUSTOMERS');
insert ignore into User_Groups(USERNAME,GROUPNAME) values ('customer2','CUSTOMERS');
insert ignore into User_Groups(USERNAME,GROUPNAME) values ('customer3','CUSTOMERS');
insert ignore into User_Groups(USERNAME,GROUPNAME) values ('admin1','ADMINISTRATORS');
insert ignore into User_Groups(USERNAME,GROUPNAME) values ('admin2','ADMINISTRATORS');

insert into Category(ID,CATEGORYNAME) values (100,'Runner');
insert into Customer(ID, CUSTNAME, EMAIL, BIRTHDATE, USERNAME) values (200, 'Mike Ross', 'mikeross@gmail.com', '1991-8-9', 'customer1');
insert into Customer(ID, CUSTNAME, EMAIL, BIRTHDATE, USERNAME) values (201, 'Harvey Specter', 'harveyspecter@gmail.com', current_timestamp, 'customer2');
insert into Customer(ID, CUSTNAME, EMAIL, BIRTHDATE, USERNAME) values (202, 'Rachel Zane', 'rachelzane@gmail.com', current_timestamp, 'customer3');
insert into Product(ID,DATEADDED,PRODUCTNAME,Category_Id) values (300,'2016-09-01','Nike HyperDunk 2016', 100);
insert into Orders(ID,AMOUNT,CONFIRMATIONNUMBER,DATEORDERED,PRODUCT_ID) values (400,100.2,10001,'2016-10-01',300);
insert into Administrator(ADMINNAME,EMAIL,USERNAME) values ('Mervin Dsouza','mervindsouza@gmail.com','admin1');
insert ignore into Orders_Customer(orders_ID,customers_ID) values (400,200);
insert ignore into Orders_Customer(orders_ID,customers_ID) values (401,201);
insert ignore into Orders_Customer(orders_ID,customers_ID) values (402,202);