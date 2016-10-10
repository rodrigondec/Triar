drop database triar;
create database triar;

create table pessoa(
	idpessoa int not null auto_increment,
	cpf varchar(18) not null,
	nome varchar(60) not null,
	data_nascimento date not null,
	email varchar(30) not null,
	telefone varchar(12) not null,
	primary key (idpessoa),
	unique (email),
	unique (telefone)
);

create table coordenador(
	idcoordenador int not null auto_increment,
	idpessoa int not null,
	primary key (idcoordenador),
	foreign key (idpessoa) references pessoa(idpessoa)
);

create table administrador(
	idadministrador int not null auto_increment,
	idpessoa int not null,
	primary key (idadministrador),
	foreign key (idpessoa) references pessoa(idpessoa)
);

create table graduado(
	idgraduado int not null auto_increment,
	idpessoa int not null,
	primary key (idgraduado),
	foreign key (idpessoa) references pessoa(idpessoa)
);

create table usuario(
	idusuario int not null auto_increment,
	idpessoa int not null,
	senha varchar(18) not null,
	receber_email int(1) not null default 1,
	primary key (idusuario),
	foreign key (idpessoa) references pessoa(idpessoa)
);

create table (
	id int not null auto_increment,
);

create table (
	id int not null auto_increment,
);

create table (
	id int not null auto_increment,
);

create table (
	id int not null auto_increment,
);

create table (
	id int not null auto_increment,
);

create table (
	id int not null auto_increment,
);