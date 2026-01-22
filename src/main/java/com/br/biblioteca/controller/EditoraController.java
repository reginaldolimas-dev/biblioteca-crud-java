package com.br.biblioteca.controller;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.biblioteca.dto.EditoraResumoDTO;
import com.br.biblioteca.service.EditoraService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/editoras")
@RequiredArgsConstructor
public class EditoraController {
	
	private final EditoraService service;
	
	@GetMapping
	public Page<EditoraResumoDTO> pesquisaPaginada(Pageable paginacao){
		return service.pesquisaPaginada(paginacao);
	}
}
