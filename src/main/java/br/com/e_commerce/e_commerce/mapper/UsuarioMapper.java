package br.com.e_commerce.e_commerce.mapper;

import br.com.e_commerce.e_commerce.dto.requisicao.UsuarioRequisicao;
import br.com.e_commerce.e_commerce.dto.resposta.UsuarioResposta;
import br.com.e_commerce.e_commerce.entity.UsuarioEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UsuarioMapper {

    public static UsuarioResposta paraRespostaDTO(UsuarioEntity usuario){
        log.debug("Mapper[Usuario] - Convertendo entidade para resposta. usuarioId={}", usuario.getId());
        return new UsuarioResposta(
                usuario.getId(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getDataDeNascimento(),
                usuario.getEmail(),
                usuario.getStatusUsuario(),
                usuario.getRoleUsuario(),
                usuario.getLojas(),
                usuario.getCriadoEm(),
                usuario.getAtualizadoEm()
        );
    }

    public static UsuarioEntity paraEntidade(UsuarioRequisicao dto){
        log.debug("Mapper[Usuario] - Convertendo DTO para entidade.");
        return UsuarioEntity.builder()
                .nome(dto.nome())
                .cpf(dto.cpf())
                .dataDeNascimento(dto.dataDeNascimento())
                .email(dto.email())
                .build();
    }
}
