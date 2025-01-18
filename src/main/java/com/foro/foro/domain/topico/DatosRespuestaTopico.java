package com.foro.foro.domain.topico;

import com.foro.foro.domain.usuarios.Usuario;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        Status status,

        Usuario usuario,
        String curso
) {
   public DatosRespuestaTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha(),
                topico.getStatus(),
                topico.getUsuario(),
                topico.getCurso()
        );
    }
}
