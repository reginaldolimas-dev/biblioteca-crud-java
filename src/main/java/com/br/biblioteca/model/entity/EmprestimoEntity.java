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
@Table(name = "emprestimo", schema = "public")
public class EmprestimoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "exemplar_id", nullable = false)
	private ExemplarEntity exemplar;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private UsuarioEntity usuario;
	
	@Column(name = "data_emprestimo", nullable = false)
	private Date dataEmprestimo;
	
	@Column(name = "data_devolucao_prevista", nullable = false)
	private Date dataDevolucaoPrevista;
	
	@Column(name = "data_devolucao_real", nullable = false)
	private Date dataDevolucaoReal;
	
	@Column(nullable = false)
	private String status;
	
}
