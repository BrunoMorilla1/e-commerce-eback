package br.com.e_commerce.e_commerce.mapper;

import br.com.e_commerce.e_commerce.dto.requisicao.LojaDtoRequisicao;
import br.com.e_commerce.e_commerce.dto.resposta.LojaDtoResposta;
import br.com.e_commerce.e_commerce.entity.LojaEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LojaMapper {

    public static LojaDtoResposta paraRespostaDto(LojaEntity loja){
        log.debug("Mapper[Loja] - Convertendo entidade para resposta. lojaId:{}", loja.getId());
        return new LojaDtoResposta(
                loja.getId(),
                loja.getNome(),
                loja.getCnpj(),
                loja.getLojaSegmentos(),
                null,
                null,
                loja.getCriadoEm(),
                loja.getAtualizadoEm()
        );
    }

    public static LojaEntity paraEntity(LojaDtoRequisicao loja){
        log.debug("Mapper[Loja] - Convertendo DTO para entidade.");
        return LojaEntity.builder()
                .nome(loja.nome())
                .cnpj(loja.cnpj())
                .lojaSegmentos(loja.lojaSegmentos())
                .build();
    }

}
