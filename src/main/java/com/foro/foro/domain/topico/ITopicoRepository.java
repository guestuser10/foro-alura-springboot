package com.foro.foro.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findByActivoTrue(Pageable pageable);

    @Query("""
    select m.activo from Topico m
        where\s
            m.id = :idTopico
    """)
    Boolean findByactivoById(Long idTopico);
}
