-- borra la bd si existe
DROP DATABASE IF EXISTS BD_TAMBO2;
-- creamos la bd
CREATE DATABASE BD_TAMBO2;
-- activamos la bd
USE BD_TAMBO2;

/*TABLAS*/
CREATE TABLE TB_DISTRITO
(
cod_dist char(5) not null primary key,
desc_dist varchar(80) not null
);

CREATE TABLE TB_CARGO
(
cod_cargo char(5) not null primary key,
desc_cargo varchar(80) not null
);

CREATE TABLE TB_CATEGORIA
(
cod_cate char(5) not null primary key,
desc_cat varchar(80) not null
);

CREATE TABLE TB_PROVEEDOR
(
cod_prove char(9) not null primary key,
nom_prove varchar(80) not null,
correo_prove varchar(80) not null,
telef_prove varchar(80) not null,
cod_dist char(5) not null,
foreign key (cod_dist) references TB_DISTRITO (cod_dist)
);


CREATE TABLE TB_EMPLEADO
(
cod_emple char(9)not null primary key,
nom_emple varchar(80) not null,
apell_emple varchar(80) not null,
fnacim  date not null,
correo_emple varchar(80) not null,
telef_emple varchar(80) not null,
cod_dist char(5) not null,
cod_cargo char(5) not null,
foreign key (cod_dist) references TB_DISTRITO (cod_dist),
foreign key (cod_cargo) references TB_CARGO (cod_cargo)
);

CREATE TABLE TB_CLIENTE
(
cod_cli char(9) not null primary key,
nom_cli varchar(80) not null,
apell_cli varchar(80) not null,
fnacim  date not null,
correo_cli varchar(80) not null,
telef_cli varchar(80) not null,
cod_dist char(5) not null,
foreign key (cod_dist) references TB_DISTRITO (cod_dist)
);

create table TB_TIPO_USUARIO(
id_tipo	char(5) not null primary key,
des_tipo varchar(80)
);



CREATE TABLE TB_USUARIO(
usuario  char(9) not null primary key,
clave    varchar(80) not null,
id_tipo  char(5) not null,
foreign key (usuario) references TB_EMPLEADO(cod_emple),
foreign key (id_tipo) references TB_TIPO_USUARIO(id_tipo)
);

CREATE TABLE TB_BOLETA
(
num_bolet varchar(10) not null primary key,
fec_bolet date not null,
hor_bolet varchar(80) not null,
cod_cli char(9) not null,
cod_emple char(9) not null,
tot_bol decimal(10,2) not null,
foreign key (cod_cli) references TB_CLIENTE (cod_cli),
foreign key (cod_emple) references TB_EMPLEADO(cod_emple)
);

CREATE TABLE TB_PRODUCTO
(
cod_prod char(10) not null primary key,
desc_prod varchar(80) not null,
prec_prod decimal(8,2) not null,
stock_prod int default 0,
cod_cate char(5) not null,
cod_prove char(9) not null,
foreign key (cod_cate) references TB_CATEGORIA(cod_cate),
foreign key (cod_prove) references TB_PROVEEDOR(cod_prove)
);
SELECT * FROM TB_BOLETA;
CREATE TABLE TB_DETALLE_BOLETA
(
num_bolet varchar(10) not null primary key,
cod_prod char(10) not null,
cant_prod int not null,
prec_prod decimal(8,2) not null,
importetotal decimal(9,2) not null,
foreign key(num_bolet) references TB_BOLETA (num_bolet),
foreign key(cod_prod) references TB_PRODUCTO(cod_prod)
);





-- INSERTAMOS DATOS

insert into TB_TIPO_USUARIO values ('T0001', 'ADMINISTRADOR');
insert into TB_TIPO_USUARIO values ('T0002', 'CLIENTE');
insert into TB_TIPO_USUARIO values ('T0003', 'CAJERO');
insert into TB_TIPO_USUARIO values ('T0004', 'MANTENIMIENTO');

insert into TB_DISTRITO values ('D0001','Ancon');
insert into TB_DISTRITO values ('D0002','Ate Vitarte');
insert into TB_DISTRITO values ('D0003','Barranco');
insert into TB_DISTRITO values ('D0004','Breña');
insert into TB_DISTRITO values ('D0005','Carabayllo');
insert into TB_DISTRITO values ('D0006','Chaclacayo');
insert into TB_DISTRITO values ('D0007','Chorrillos');
insert into TB_DISTRITO values ('D0008','Cieneguilla');
insert into TB_DISTRITO values ('D0009','Comas');
insert into TB_DISTRITO values ('D0010','El Agustino');
insert into TB_DISTRITO values ('D0011','Independencia');
insert into TB_DISTRITO values ('D0012','Jesús María');
insert into TB_DISTRITO values ('D0013','La Molina');
insert into TB_DISTRITO values ('D0014','La Victoria');
insert into TB_DISTRITO values ('D0015','Lima');
insert into TB_DISTRITO values ('D0016','Lince');
insert into TB_DISTRITO values ('D0017','Los Olivos');
insert into TB_DISTRITO values ('D0018','Lurigancho');
insert into TB_DISTRITO values ('D0019','Lurín');
insert into TB_DISTRITO values ('D0020','Magdalena del Mar');
insert into TB_DISTRITO values ('D0021','Miraflores');
insert into TB_DISTRITO values ('D0022','Pachacamac');
insert into TB_DISTRITO values ('D0023','Pucusana');
insert into TB_DISTRITO values ('D0024','Pueblo Libre');
insert into TB_DISTRITO values ('D0025','Punta Hermosa');
insert into TB_DISTRITO values ('D0026','Punta Negra');
insert into TB_DISTRITO values ('D0027','Rímac');
insert into TB_DISTRITO values ('D0028','San Bartolo');
insert into TB_DISTRITO values ('D0029','San Borja');
insert into TB_DISTRITO values ('D0030','San Isidro');
insert into TB_DISTRITO values ('D0031','San Juan de Lurigancho');
insert into TB_DISTRITO values ('D0032','San Juan de Miraflores');
insert into TB_DISTRITO values ('D0033','San Luis');
insert into TB_DISTRITO values ('D0034','San Martín de Porres');
insert into TB_DISTRITO values ('D0035','San Miguel');
insert into TB_DISTRITO values ('D0036','Santa Anita');
insert into TB_DISTRITO values ('D0037','Santa María del Mar');
insert into TB_DISTRITO values ('D0038','Santa Rosa');
insert into TB_DISTRITO values ('D0039','Santiago de Surco');
insert into TB_DISTRITO values ('D0040','Surquillo');
insert into TB_DISTRITO values ('D0041','Villa El Salvador');
insert into TB_DISTRITO values ('D0042','Villa María del Triunfo');


insert into TB_CARGO values ('CR001','ASISTENTE');
insert into TB_CARGO values ('CR002','AUXILIAR');
insert into TB_CARGO values ('CR003','SUPERVISOR');
insert into TB_CARGO values ('CR004','COORDINADOR');
insert into TB_CARGO values ('CR005','OPERADOR');
insert into TB_CARGO values ('CR006','JEFE');



INSERT INTO TB_CATEGORIA VALUES	('CA101','BEBIDAS ALCOHOLICAS');
INSERT INTO TB_CATEGORIA VALUES	('CA102','BEBIDAS');
INSERT INTO TB_CATEGORIA VALUES	('CA103','REPOSTERIA');
INSERT INTO TB_CATEGORIA VALUES	('CA104','HELADOS');
INSERT INTO TB_CATEGORIA VALUES	('CA105','COMIDA RAPIDAS');
INSERT INTO TB_CATEGORIA VALUES	('CA106','LACTEOS');
INSERT INTO TB_CATEGORIA VALUES	('CA107','SNACKS');
INSERT INTO TB_CATEGORIA VALUES	('CA108','ABARROTES');
INSERT INTO TB_CATEGORIA VALUES	('CA109','GALLETAS');
INSERT INTO TB_CATEGORIA VALUES	('CA110','GOLOSINAS');



INSERT INTO TB_PROVEEDOR VALUES	('RUC000001' ,'GLORIA'   , 'GLORIA.SA@HOTMAIL.COM','953159488','D0033');
INSERT INTO TB_PROVEEDOR VALUES ('RUC000002' ,'LAYS'     , 'LAYS01.@HOTMAIL.COM'  ,'985612751','D0015');
INSERT INTO TB_PROVEEDOR VALUES ('RUC000003' ,'LAIVE'    , 'LAIVE@HOTMAIL.COM'    ,'958246874','D0002');
INSERT INTO TB_PROVEEDOR VALUES ('RUC000004' ,'PRIMOR'   , 'PRIMOR@HOTMAIL.COM'   ,'908563565','D0011');
INSERT INTO TB_PROVEEDOR VALUES ('RUC000005' ,'COCA COLA', 'COCA_COLA@HOTMAIL.COM','961904294','D0024');
INSERT INTO TB_PROVEEDOR VALUES ('RUC000006' ,'MOLITALIA', 'MOLITALIA@HOTMAIL.COM','965625362','D0014');
INSERT INTO TB_PROVEEDOR VALUES ('RUC000007' ,'ARCOR'    , 'ARCOR@HOTMAIL.COM'    ,'975533274','D0006');
INSERT INTO TB_PROVEEDOR VALUES ('RUC000008' ,'AMBROSOLI', 'AMBROSOLI@HOTMAIL.COM','985863563','D0001');
INSERT INTO TB_PROVEEDOR VALUES ('RUC000009' ,'ELITE'    , 'ELITE@HOTMAIL.COM'    ,'925896374','D0025');
INSERT INTO TB_PROVEEDOR VALUES	('RUC000010','BIMBO'    , 'BIMBO_02@HOTMAIL.COM' ,'986248261','D0013');
INSERT INTO TB_PROVEEDOR VALUES	('RUC000011','BACKUS'   , 'BACKUS@HOTMAIL.COM'   ,'931086574','D0017');
INSERT INTO TB_PROVEEDOR VALUES	('RUC000012','CARABELA' , 'CARABELA@HOTMAIL.COM' ,'991175363','D0009');
INSERT INTO TB_PROVEEDOR VALUES ('RUC000013','NESTLE'   , 'NESTLE@HOTMAIL.COM'   ,'968711391','D0008');
INSERT INTO TB_PROVEEDOR VALUES ('RUC000014','PEPSI'    , 'PEPSI@HOTMAIL.COM'    ,'906295473','D0006');
INSERT INTO TB_PROVEEDOR VALUES ('RUC000015','DONOFRIO' , 'DONOFRIO@HOTMAIL.COM' ,'921547847','D0028');
INSERT INTO TB_PROVEEDOR VALUES ('RUC000016','Head & Shoulders' ,'Head & Shoulders@HOTMAIL.COM' ,'936254146','D0006');
INSERT INTO TB_PROVEEDOR VALUES ('RUC000017','REDONDOS' , 'REDONDOS@HOTMAIL.COM' ,'989456146','D0033');
INSERT INTO TB_PROVEEDOR VALUES ('RUC000018','SAN FERNANDO' , 'SAN_FERNANDO@HOTMAIL.COM' ,'925814605','D0008');
INSERT INTO TB_PROVEEDOR VALUES ('RUC000019','PRINGLES' , 'PRINGLES@HOTMAIL.COM' ,'932457949','D0009');
INSERT INTO TB_PROVEEDOR VALUES ('RUC000020','LAVAGGI' , 'LAVAGGI@HOTMAIL.COM' ,'905378696','D0007');

insert into TB_PRODUCTO values ('PR00000001','Papas Lays',1.85,45,'CA107','RUC000002');
insert into TB_PRODUCTO values ('PR00000002','Cerveza Pilsen 6x320 ml',32.90,87,'CA101','RUC000011');
insert into TB_PRODUCTO values ('PR00000003','Cerveza Corono 6x355 ml',39.90,30,'CA101','RUC000011');
insert into TB_PRODUCTO values ('PR00000004','Pizza familiar Carnivora',14.90,45,'CA105','RUC000017');
insert into TB_PRODUCTO values ('PR00000005','Pizza familiar Americana',11.99,65,'CA105','RUC000017');
insert into TB_PRODUCTO values ('PR00000006','Pizza familiar Hawaiana',12.90,12,'CA105','RUC000017');
insert into TB_PRODUCTO values ('PR00000007','Helado Peziduri Tricolor',12.90,20,'CA104','RUC000015');
insert into TB_PRODUCTO values ('PR00000008','Chocolate Triangulo 30gr',1.00,15,'CA110','RUC000015');
insert into TB_PRODUCTO values ('PR00000009','Galletas Morochas Mini',1.00,78,'CA109','RUC000007');
insert into TB_PRODUCTO values ('PR00000010','Mikes hard limonade 4x350 ml',15.90,10,'CA102','RUC000011');
insert into TB_PRODUCTO values ('PR00000011','Papas Pringles Original 37 g',4.50,52,'CA107','RUC000019');
insert into TB_PRODUCTO values ('PR00000012','Snack Pringles Sour & Cream Onion 124 g',9.50,35,'CA107','RUC000019');
insert into TB_PRODUCTO values ('PR00000013','Snack Pringles Original 124 g',9.50,14,'CA107','RUC000019');
insert into TB_PRODUCTO values ('PR00000014','Huevo Pardo La Calera 15 und',7.50,25,'CA108','RUC000018');
insert into TB_PRODUCTO values ('PR00000015','Aceite Primor Clásico 1 Lt',7.20,75,'CA108','RUC000004');
insert into TB_PRODUCTO values ('PR00000016','Azúcar Rubia Corazón del Fundo 1 Kg',3.00,68,'CA108','RUC000020');
insert into TB_PRODUCTO values ('PR00000017','Arroz Costeño Graneadito 750 g',3.90,12,'CA108','RUC000006');
insert into TB_PRODUCTO values ('PR00000018','Leche Evaporada Gloria Light 400 g',3.20,25,'CA106','RUC000001');
insert into TB_PRODUCTO values ('PR00000019','Maíz Pop Corn Corazón Del Fundo 450 g',2.70,30,'CA108','RUC000020');
insert into TB_PRODUCTO values ('PR00000020','Conserva Trozos de Atún Florida 170 g',6.00,86,'CA108','RUC000006');
insert into TB_PRODUCTO values ('PR00000021','Conserva de Duraznos Arica 820 g',8.20,29,'CA108','RUC000006');
insert into TB_PRODUCTO values ('PR00000022','Pastelito Pingüino Marinela 80 g',3.40,24,'CA103','RUC000010');
insert into TB_PRODUCTO values ('PR00000023','Keke Bimbolete De Vainilla 82.5 g',3.30,38,'CA103','RUC000010');
insert into TB_PRODUCTO values ('PR00000024','Brownie con Trozos de Princesa 55 g',2.60,18,'CA103','RUC000010');
insert into TB_PRODUCTO values ('PR00000025','Gomitas Ambrosoli Ambrosito 100 g',4.50,38,'CA110','RUC000007');
insert into TB_PRODUCTO values ('PR00000026','Marshmellows Olé Olé Bolsita 7 unid 4.5 g',1.10,68,'CA110','RUC000007');
insert into TB_PRODUCTO values ('PR00000027','Gaseosa Pepsi 1.5 Lt',4.45,75,'CA102','RUC000014');
insert into TB_PRODUCTO values ('PR00000028','Gaseosa Guaraná Vitaminizada 2 L',6.00,28,'CA102','RUC000011');
insert into TB_PRODUCTO values ('PR00000029','Gaseosa Oro 400 ml',1.60,45,'CA102','RUC000011');
insert into TB_PRODUCTO values ('PR00000030','Bebida Energizante Red Bull 250 ml',6.90,38,'CA102','RUC000011');
insert into TB_PRODUCTO values ('PR00000031','Bebida Energizante Monster Energy Ultra 473 ml',8.50,57,'CA102','RUC000011');
insert into TB_PRODUCTO values ('PR00000032','Agua San Luis Sin Gas Tapa Plana 1 Lt',2.00,14,'CA102','RUC000011');
insert into TB_PRODUCTO values ('PR00000033','Cigarro Lucky Strike Crush 20',18.20,36,'CA107','RUC000011');
insert into TB_PRODUCTO values ('PR00000034','Cigarro Winston Red 10 und',8.60,86,'CA107','RUC000011');
insert into TB_PRODUCTO values ('PR00000035','Whisky Jack Daniels 375 ml',60.90,54,'CA101','RUC000011');
insert into TB_PRODUCTO values ('PR00000036','Whisky Old Parr 750 ml',87.90,53,'CA101','RUC000011');
insert into TB_PRODUCTO values ('PR00000037','Whisky Johnnie Walker Red Label 750 ml',53.90,86,'CA101','RUC000011');



SELECT * FROM TB_CLIENTE ORDER BY cod_cli DESC LIMIT 1;
SELECT SUBSTRING(MAX(cod_dist),4) FROM TB_DISTRITO;
/*select * from TB_CATEGORIA WHERE cod_cate=?;*/

SELECT * FROM TB_TIPO_USUARIO;
SELECT * FROM TB_EMPLEADO;
SELECT * FROM TB_CLIENTE;
SELECT * FROM TB_USUARIO;
/*UPDATE TB_EMPLEADO SET usuario='xxxxx',clave='xxxxx' WHERE cod_emple='EM0000001';
DELETE FROM TB_USUARIO WHERE codigo_usu='T000000002';*/

/*SELECT P.CODIGO_USU,P.NOMBRE,P.APELLIDO,P.USUARIO,P.CLAVE,P.FNACIM,T.DES_TIPO
FROM TB_USUARIO P
INNER JOIN TB_TIPO_USUARIO T
ON P.ID_TIPO=T.ID_TIPO
ORDER BY P.CODIGO_USU ASC;*/


/*SELECT cod_emple FROM TB_EMPLEADO WHERE usuario='';*/

DELIMiTER $$
create procedure usp_validaAcceso (usr varchar(80), pas varchar(30))
begin
select * from tb_usuario where usuario = usr and clave = pas;
end$$
DELIMiTER ;

insert into TB_EMPLEADO values ('E10000001', 'Roberto', 'Alvarez Gonzales', '1980/08/08', 'ralvarezg@gmail.com', '945867321', 'D0040', 'CR006');
insert into TB_EMPLEADO values ('E10000002', 'Angela', 'Gutierrez Ordeñez', '1999/06/07', 'agutirrezg@gmail.com', '958674123', 'D0040', 'CR005');
insert into TB_EMPLEADO values ('E10000003', 'Jimena', 'Chavez Jimenez', '1997/03/09', 'jchavezj@gmail.com', '912365478', 'D0040', 'CR005');
insert into TB_EMPLEADO values ('E10000004', 'Gianela', 'Dominguez Lopez', '1993/01/12', 'gdominguezl@gmail.com', '985632741', 'D0040', 'CR005');
/*
select *  from tb_empleado where cod_emple=?;*/

insert into TB_USUARIO values('E10000001','cibertec','T0001');

DROP PROCEDURE IF EXISTS usp_registraCategoria;
delimiter $$
create procedure usp_registraCategoria(
	in desc_cat varchar(80)
)
begin
	Select ifnull((select concat('CA',convert(SUBSTRING(max(cod_cate),3), unsigned)+1) FROM TB_CATEGORIA), 'CA101') into @cod_cate;
	insert into TB_CATEGORIA values (
    @cod_cate,
    desc_cat);
end $$
delimiter ;







/*DROP PROCEDURE IF EXISTS usp_registraCategoria;
delimiter $$
create procedure usp_registraCategoria(
	in desc_cat varchar(80)
)
begin
-- declare cod_cli char(9);
select ifnull((SELECT concat('CA',convert(SUBSTRING(MAX(cod_cate),length(MAX(cod_cate),3)),unsigned)+1) FROM TB_CATEGORIA), 'CA101') into @cod_cate;
	insert into TB_CATEGORIA values (
    @cod_cate,
    desc_cat);
end $$
delimiter ;*/
	
SELECT * FROM TB_CATEGORIA;
call usp_registraCategoria('TOMATEs');
call usp_registraCategoria('TOMATEs');
call usp_registraCategoria('TOMATEs');