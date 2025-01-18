package com.foro.foro.domain.topico;

import com.foro.foro.domain.usuarios.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank(message = "El título es obligatorio")
        String titulo,
        @NotBlank(message = "El mensaje es obligatorio")
        String mensaje,
        @NotNull(message = "El status es obligatorio")
        Status status,
        @NotBlank(message = "El curso es obligatorio")
        String curso
) {
}
