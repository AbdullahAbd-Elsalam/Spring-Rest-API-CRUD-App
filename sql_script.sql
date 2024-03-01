use hib ;


create table hib.ProductDetail(id int  auto_increment primary key not null ,
                               name varchar(255) not null , expirationDate varchar(255) not null ,
                               manufacturer varchar(255) not null , price double not null , available boolean
                                   default false


);
create table hib.Product(id int primary key  auto_increment not null ,
                         name varchar(255) not null ,
                         product_detail_id int not null ,
                         foreign key (product_detail_id) references ProductDetail(id)

);

INSERT INTO hib.ProductDetail (id, name, expirationDate, manufacturer, price, available) VALUES (1,'milk', '2024-02-08', 'dina farms', 30, 1);
INSERT INTO hib.ProductDetail (id, name, expirationDate, manufacturer, price, available) VALUES (2,'fish', '2024-02-15', 'abu elsayed', 100, 1);
INSERT INTO hib.ProductDetail (id, name, expirationDate, manufacturer, price, available) VALUES (3,'cheese', '2024-06-11', 'dina farms', 50, 1);
INSERT INTO hib.ProductDetail (id, name, expirationDate, manufacturer, price, available) VALUES (4,'chocolate ', '2024-02-29', 'cadbury', 60, 0);

INSERT INTO hib.product (id, name , product_detail_id) VALUES (1, 'milk' , 1);
INSERT INTO hib.product (id, name , product_details_id) VALUES (2, 'fish' , 2);
INSERT INTO hib.product (id, name , product_details_id) VALUES (3, 'cheese' , 3);
INSERT INTO hib.product (id, name , product_details_id) VALUES (4, 'chocolate' , 4);