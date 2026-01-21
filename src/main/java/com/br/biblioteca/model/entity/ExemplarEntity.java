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
@Table(name = "exemplar", schema = "public")
public class ExemplarEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "livro_id", nullable = false)
	private LivroEntity livro;
	
	@Column(name = "codigo_exemplar", nullable = false)
	private String codigoExemplar;
	
	@Column(nullable = false)
	private String localizacao;
	
	@Column(nullable = false)
	private String status;
	
	@Column(name = "data_aquisicao", nullable = false)
	private Date dataAquisicao;

}
