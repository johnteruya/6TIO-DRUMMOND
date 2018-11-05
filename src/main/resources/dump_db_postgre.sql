drop database if exists doacoesapp;

create table doacao (
	id_doacao bigint not null primary key,
	nome_doacao varchar(255) not null,
	tipo_item varchar(255) not null,
	doador_id_doador bigint not null
);

create table doador (
	id_doador bigint not null primary key,
	bairro varchar(255) not null,
	complemento varchar(255),
	contato varchar(255) not null,
	cpf_cnpj  varchar(255) not null,
	data varchar(255) not null,
	endereco varchar(255) not null,
	estado varchar(255) not null,
	nome_doador varchar(255) not null,
	tipo_doador varchar(255) not null
);

create table doador_doacao (
	doador_id_doador bigint not null,
	doacao_id_doacao bigint primary key
);

create table role (
	nome_role varchar(255) not null primary key
);

create table usuario (
	login varchar(255) not null primary key,
	nome_completo varchar(255),
	senha varchar(255) not null
);

create table usuarios_roles (
usuario_id varchar(255) not null,
role_id varchar(255) not null
);

create sequence hibernate_sequence;


/* DEFAULT INSERT */

insert into usuarios_roles values ('admin','ROLE_ADMIN');
insert into usuarios_roles values ('user','ROLE_USER');


insert into usuario values ('admin','admin','$2a$10$YgfXvTdbT7VOVtFn/xeJTOXloz/KmC7am6lttFJxwWwETiBLqBJCq');

insert into usuario values ('user','user','$2a$10$S/1O/xVWEpffUioV/EcY7e81ifeocWV3jLt5lIbcQzQW/jGyoU.PK');

 
insert into role values ('ROLE_ADMIN');
insert into role values ('ROLE_USER');