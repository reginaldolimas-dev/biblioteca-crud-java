package com.br.biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.biblioteca.dto.EditoraResumoDTO;
import com.br.biblioteca.repository.EditoraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditoraService {
	
	private final EditoraRepository repository;

	public Page<EditoraResumoDTO> pesquisaPaginada(Pageable paginacao) {
		return repository.findAllBy(paginacao);
	}

}
