package com.br.biblioteca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.biblioteca.dto.EditoraResumoDTO;
import com.br.biblioteca.model.entity.EditoraEntity;

@Repository
public interface EditoraRepository extends JpaRepository<EditoraEntity, Long> {
	
	Page<EditoraResumoDTO> findAllBy(Pageable paginacao);

}
