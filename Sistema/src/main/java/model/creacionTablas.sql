/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
*  Recordemos hacer un Create DaTabase en Services, en Java DB
*  Primero debemos ver que la base de datos este en Ejecución... dando un start database
*  Luego damos create database y llamamos a la base de datos "ugeneral"
*  El usuario debe ser "root" y la contraseña igualmente "root"
 */

drop table puesto;
create table puesto(codigo varchar(10) not null primary key,nombre varchar(70) not null);

insert into puesto values('CS-910','Sistemas de Gestión de Calidad');
insert into puesto values('CS-920','Gestión del Conocimiento');
insert into puesto values('CS-930','Modelos y Normas de Calidad TIC');
insert into puesto values('CS-940','Medición de Sistemas de Información');
insert into puesto values('CS-950','Auditoría de la Calidad TIC');
insert into puesto values('CS-960','Seminario de Investigación ');
insert into puesto values('II-515','Computación Aplicada');
insert into puesto values('SC-103','Introducción a la Informática ');
insert into puesto values('SC-115','Programación Básica ');
insert into puesto values('SC-202','Introducción a la Programación');
insert into puesto values('SC-203','Fundamentos de Sistemas Operativos');
insert into puesto values('SC-204','Principios de Redes y Comunicaciones');
insert into puesto values('SC-205','Electrónica Digital y Microprocesadores');
insert into puesto values('SC-250','Paradigmas de Programación ');
insert into puesto values('SC-270','Computación y Sociedad');
insert into puesto values('SC-302','Documentación del Software ');
insert into puesto values('SC-303','Programación Cliente/Servidor Concurrente ');
insert into puesto values('SC-304','Estructura de Datos ');





drop table usuario;

create table usuario (
  id varchar(10) primary key,
  pw varchar(10) not null, 
  nombre varchar(20) not null
);
insert into usuario values ('juan','123','Juan Pablo'),
                          ('pedro','321','Pedro Cardenas'),
                          ('ana','456','Ana Mendez'),
                          ('rebeca','654','Rebeca Alfaro');

drop table prospecto;
create table prospecto (cedula varchar(10) primary key,
nombre varchar(20) not null,
Apellido1 varchar(15) not null,
Apellido2 varchar(15) not null,
fechaNacimiento date not null,
fechaliquidacion date not null,
fechaPosibleIngreso date not null,
correo varchar(30) not null,
celular varchar(30) not null);

insert into prospecto values('101690136','BLANCA ROSA','ARIAS','UMAÑA','1988-06-10','2016-11-06','2016-11-06','correo1@gmial.com','8888-1111'),
('103620571','EDGAR','ALVAREZ','GAMBOA','1991-02-02','2019-02-02','2016-11-06','correo1@gmial.com','8888-2222'),
('106070605','ANA CECILIA','BALLESTERO','LEIVA','1989-05-28','2019-10-06','2016-11-06','correo1@gmial.com','8888-3333'),
('112360060','SOLANGE MARIA','SALAZAR','MORA','1991-12-12','2017-10-26','2016-11-06','correo1@gmial.com','8888-4444'),
('112360600','ALBERTO JOSE','URTECHO','CRUZ','1985-12-14','2019-04-13','2016-11-06','correo1@gmial.com','8888-5555'),
('113610699','LEANDRO ALBERTO','CORRALES','LORIA','1993-02-07','2016-02-17','2016-11-06','correo1@gmial.com','8888-66666'),
('113620237','OSCAR ESTEBAN','BONILLA','RODRIGUEZ','1990-06-22','2019-02-06','2016-11-06','correo1@gmial.com','8888-7777'),
('113620770','WILLIAM ADRIAN','PRADO','SOLIS','1990-07-06','2017-10-18','2016-11-06','correo1@gmial.com','8888-88888',
('102730126','MARIA LUISA','CASTRO','MENA','1988-04-05','2015-10-15','2016-11-06','correo1@gmial.com','8888-9999'),
('102740397','RAFAEL','IBARRA','ROJAS','1986-02-17','2016-02-14','2016-11-06','correo1@gmial.com','8823-0000'),
('102750797','GLADYS DEL CARMEN','FLORES','ZELEDON','1989-03-26','2015-02-10','2016-11-06','correo1@gmial.com','8883-2121');

drop table empleado;
create table empleado (id varchar(10) primary key,
  nombre varchar(20) not null,
  apellido1 varchar(15) not null,
  apellido2 varchar(15) not null,
  fechaNaci date not null,
  fechaIngr date not null,
  genero varchar(1));

insert into empleado values('101690136','BLANCA ROSA','ARIAS','UMAÑA','1988-06-10','2016-11-06','F');
insert into empleado values('101750623','JUAN PEDRO','FERNANDEZ','CORRALES','1992-03-15','2019-02-21','M');
insert into empleado values('101800586','MARIA MANUELA','FERNANDEZ','AGUERO','1984-11-04','2016-08-08','F');
insert into empleado values('101840937','DORA FLORENCIA','BLANCO','PICADO','1993-02-07','2019-03-25','F');
insert into empleado values('101890048','BERTA','BERMUDEZ','MONGE','1995-02-07','2016-02-24','F');
insert into empleado values('101920700','ODILIA','VARGAS','ALVAREZ','1991-02-23','2017-02-23','F');
insert into empleado values('101960154','BERNARDO','CASTILLO','CORDERO','1988-01-22','2016-02-02','M');
insert into empleado values('101990402','MARIA LUISA','QUIROS','ASTUA','1987-01-10','2019-07-21','F');
insert into empleado values('102020545','ALICE','NAVARRO','ULATE','1986-07-13','2017-02-21','F');
insert into empleado values('102050523','OFELIA','ASTUA','ULLOA','1985-05-20','2015-04-13','F');
insert into empleado values('102080433','PANFILO','AGUERO','BERMUDEZ','1994-01-29','2018-03-16','M');
insert into empleado values('102100966','SERGIO','RIVERO','ZUÑIGA','1986-03-29','2018-02-09','M');
insert into empleado values('102130509','NORMA','ARIAS','GAMBOA','1986-05-25','2017-02-18','F');
insert into empleado values('102150916','MARIA CRISTINA','ABARCA','BEJARANO','1991-04-22','2019-12-03','F');
insert into empleado values('102180268','MARIA LUZ','UMAÑA','VEGA','1988-02-15','2018-02-13','F');
insert into empleado values('102200406','HUMBERTO','MONGALO','GURDIAN','1988-02-27','2017-10-10','M');
insert into empleado values('102220662','JOSE ENRIQUE','CHAVES','MONGE','1995-06-29','2017-02-13','M');
insert into empleado values('102240828','MARIA TERESA','TRUQUE','VEGA','1993-02-07','2017-02-12','F');





create table periodo (id varchar (5) not null primary key, fechaInicio Date,fechaFin Date);
insert into periodo values 
('20171','2017-01-01','2017-04-21'),
('20172','2017-05-01','2017-08-21'),
('20173','2017-09-01','2017-12-21'),
('20181','2018-01-01','2017-04-21'),
('20182','2018-05-01','2017-08-21'),
('20183','2018-09-01','2017-12-21'),
('20191','2019-01-01','2017-04-21'),
('20192','2019-05-01','2017-08-21');

drop table rango;
create table rango (
  idEmpleado varchar(10) not null, 
  idPuesto varchar(10) not null,
  periodo varchar(5) not null,
  rango double, 
  primary key (idEmpleado,idPuesto, periodo),
  foreign key (idEmpleado) references empleado(id),
  foreign key (idPuesto) references puesto(codigo),
  foreign key (periodo) references periodo(id)
);

insert into rango values ('101690136','CS-910','20171',68);
insert into rango values ('101690136','CS-920','20172',56);
insert into rango values ('101690136','CS-930','20173',64);
insert into rango values ('101690136','CS-940','20181',100);
insert into rango values ('101690136','CS-940','20182',55);
insert into rango values ('101690136','CS-950','20183',56);
insert into rango values ('101690136','CS-950','20191',55);
insert into rango values ('101690136','CS-960','20192',69);
insert into rango values ('101690136','CS-960','20171',78);
insert into rango values ('101690136','II-515','20172',61);
insert into rango values ('101690136','II-515','20173',84);
insert into rango values ('101690136','SC-103','20181',50);
insert into rango values ('101690136','SC-103','20182',55);
insert into rango values ('101690136','SC-115','20183',72);
insert into rango values ('101690136','SC-115','20191',95);
insert into rango values ('101690136','SC-202','20192',51);
insert into rango values ('101690136','SC-202','20171',84);
insert into rango values ('101690136','SC-203','20172',93); 
