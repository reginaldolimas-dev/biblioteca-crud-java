package com.br.biblioteca.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.biblioteca.dto.EditoraFiltroDTO;
import com.br.biblioteca.dto.EditoraResumoDTO;
import com.br.biblioteca.repository.EditoraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditoraService {
	
	private final EditoraRepository repository;

	public Page<EditoraResumoDTO> pesquisaPaginada(EditoraFiltroDTO filtro, Pageable paginacao) {
		return repository.buscarPorFiltros(new EditoraFiltroDTO(
	            					filtro.getNome() != null && !filtro.getNome().isBlank() ? filtro.getNome() : null,
	            					filtro.getCidade() != null && !filtro.getCidade().isBlank() ? filtro.getCidade() : null), paginacao);
	}

}
