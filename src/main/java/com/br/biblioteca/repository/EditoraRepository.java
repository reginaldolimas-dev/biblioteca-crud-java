package com.br.biblioteca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.biblioteca.dto.EditoraFiltroDTO;
import com.br.biblioteca.dto.EditoraResumoDTO;
import com.br.biblioteca.model.entity.EditoraEntity;

@Repository
public interface EditoraRepository extends JpaRepository<EditoraEntity, Long> {
	
	@Query("""
			select 
            e.id as id,
            e.nome as nome,
            e.pais as pais,
            e.cidade as cidade,
            e.cnpj as cnpj
        from EditoraEntity e
        where (:#{#filtro.nome} is null 
               or lower(e.nome) like lower(concat('%', :#{#filtro.nome}, '%')))
          and (:#{#filtro.cidade} is null 
               or lower(e.cidade) like lower(concat('%', :#{#filtro.cidade}, '%')))
			""")
	Page<EditoraResumoDTO> buscarPorFiltros(@Param("filtro") EditoraFiltroDTO filtro, Pageable paginacao);

}
