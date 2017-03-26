insert into Category(ID,CATEGORYNAME) values (100,'Runner');
insert into Customer(ID,CUSTNAME,EMAIL) values (200, 'Mike Ross', 'mikeross@gmail.com');
insert into Product(ID,DATEADDED,PRODUCTNAME,Category_Id) values (300,'2016-09-01','Nike HyperDunk 2016', 100);
insert into Orders(ID,AMOUNT,CONFIRMATIONNUMBER,DATEORDERED,PRODUCT_ID) values (400,100.2,10001,'2017-13-01',300);
insert into Orders_Customer(orders_ID,customers_ID) values (400,200);