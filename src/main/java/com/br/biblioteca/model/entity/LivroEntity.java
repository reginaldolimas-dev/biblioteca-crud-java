package com.br.biblioteca.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "livro", schema = "public")
public class LivroEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String isbn;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(name = "ano_publicacao", nullable = false)
	private Date anoPublicacao;
	
	@Column(nullable = false)
	private Integer edicao;
	
	@Column(name = "num_paginas", nullable = false)
	private Integer numeroPaginas;
	
	@Column(nullable = false)
	private String idioma;
	
	@ManyToOne
	@JoinColumn(name = "editora_id", nullable = false)
	private EditoraEntity editora;

}
