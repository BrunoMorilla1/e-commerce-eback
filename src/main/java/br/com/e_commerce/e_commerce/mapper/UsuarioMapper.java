package br.com.e_commerce.e_commerce.mapper;

import br.com.e_commerce.e_commerce.dto.requisicao.UsuarioRequisicao;
import br.com.e_commerce.e_commerce.dto.resposta.LojaDtoResposta;
import br.com.e_commerce.e_commerce.dto.resposta.UsuarioResposta;
import br.com.e_commerce.e_commerce.entity.LojaEntity;
import br.com.e_commerce.e_commerce.entity.UsuarioEntity;
import br.com.e_commerce.e_commerce.enums.RoleUsuario;
import br.com.e_commerce.e_commerce.enums.StatusUsuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@Slf4j
public class UsuarioMapper {

    public static UsuarioResposta paraRespostaDTO(UsuarioEntity usuario) {
        log.debug("Mapper[Usuario] - Convertendo entidade para resposta. usuarioId={}", usuario.getId());

        List<LojaDtoResposta> lojasDto = null;
        if (usuario.getLojas() != null && !usuario.getLojas().isEmpty()) {
            lojasDto = usuario.getLojas().stream()
                    .map(loja -> new LojaDtoResposta(
                            loja.getId(),
                            loja.getNome(),
                            loja.getCnpj(),
                            loja.getLojaSegmentos(),
                            null,
                            null,
                            loja.getCriadoEm(),
                            loja.getAtualizadoEm()
                    ))
                    .toList();
        }

        return new UsuarioResposta(
                usuario.getId(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getDataDeNascimento(),
                usuario.getEmail(),
                usuario.getStatusUsuario(),
                usuario.getRoleUsuario(),
                lojasDto,
                usuario.getCriadoEm(),
                usuario.getAtualizadoEm()
        );
    }

    public static UsuarioEntity paraEntidade(UsuarioRequisicao dto) {
        log.debug("Mapper[Usuario] - Convertendo DTO para entidade.");
        return UsuarioEntity.builder()
                .nome(dto.nome())
                .cpf(dto.cpf())
                .dataDeNascimento(dto.dataDeNascimento())
                .email(dto.email())
                .statusUsuario(StatusUsuario.ATIVO)
                .roleUsuario(RoleUsuario.USUARIO)
                .build();
    }


}