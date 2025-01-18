package com.foro.foro.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String usuario,
        Status status,
        LocalDateTime fecha
) {
    public DatosListadoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getUsuario().getLogin(),
                topico.getStatus(),
                topico.getFecha());
    }
}
