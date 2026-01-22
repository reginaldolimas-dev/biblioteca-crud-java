create table editora(
	id BIGSERIAL primary key,
	nome varchar not null,
	pais varchar not null,
	cidade varchar not null,
	cnpj varchar not null,
	data_criacao timestamp default current_timestamp
);

create table livro(
	id BIGSERIAL primary key,
	isbn varchar not null,
	titulo varchar not null,
	ano_publicacao date not null,
	edicao integer not null,
	num_paginas integer not null,
	idioma varchar not null,
	editora_id bigint not null,
	
	CONSTRAINT fk_livro_editora FOREIGN KEY (editora_id) references editora(id)
);

create table exemplar(
	id BIGSERIAL primary key,
	livro_id bigint not null,
	codigo_exemplar varchar not null,
	localizacao varchar not null,
	status varchar not null,
	data_aquisicao date not null,
	
	CONSTRAINT fk_exemplar_livro FOREIGN KEY(livro_id) REFERENCES livro(id)
);

create table usuario(
	id BIGSERIAL primary key,
	nome varchar not null,
	cpf varchar not null,
	email varchar not null,
	telefone varchar not null,
	endereco varchar not null,
	data_cadastro date not null default current_date
);

create table emprestimo(
	id BIGSERIAL primary key,
	exemplar_id bigint,
	usuario_id bigint,
	data_emprestimo date not null,
	data_devolucao_prevista date not null,
	data_devolucao_real date,
	status varchar not null,
	
	constraint fk_emprestimo_exemplar foreign key(exemplar_id) references exemplar(id),
	constraint fk_emprestimo_usuario foreign key(usuario_id) references usuario(id)
);



