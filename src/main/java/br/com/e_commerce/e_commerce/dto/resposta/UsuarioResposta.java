package br.com.e_commerce.e_commerce.dto.resposta;

import br.com.e_commerce.e_commerce.entity.LojaEntity;
import br.com.e_commerce.e_commerce.enums.RoleUsuario;
import br.com.e_commerce.e_commerce.enums.StatusUsuario;

import java.time.LocalDateTime;
import java.util.List;

public record UsuarioResposta(

        Long id,
        String nome,
        String cpf,
        String dataDeNascimento,
        String email,
        StatusUsuario statusUsuario,
        RoleUsuario roleUsuario,
        List<LojaEntity> lojas,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm) {
}
