package br.com.e_commerce.e_commerce.mapper;

import br.com.e_commerce.e_commerce.dto.requisicao.LojaDtoRequisicao;
import br.com.e_commerce.e_commerce.dto.resposta.LojaDtoResposta;
import br.com.e_commerce.e_commerce.dto.resposta.ProdutoDtoResposta;
import br.com.e_commerce.e_commerce.entity.LojaEntity;
import br.com.e_commerce.e_commerce.entity.ProdutoEntity;
import br.com.e_commerce.e_commerce.enums.StatusLoja;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class LojaMapper {

    public static LojaDtoResposta paraRespostaDto(LojaEntity loja){
        log.debug("Mapper[Loja] - Convertendo entidade para resposta. lojaId:{}", loja.getId());

        List<ProdutoDtoResposta> listaProduto = null;
        if (loja.getProduto() != null && !loja.getProduto().isEmpty()){
            listaProduto = loja.getProduto().stream()
                    .map(produto -> new ProdutoDtoResposta(
                            produto.getId(),
                            produto.getNome(),
                            produto.getDescricao(),
                            produto.getQuantidade(),
                            produto.getValor(),
                            null,
                            produto.getStatusProduto(),
                            produto.getCriadoEm(),
                            produto.getAtualizadoEm()
                    ))
                    .toList();
        }
        return new LojaDtoResposta(
                loja.getId(),
                loja.getNome(),
                loja.getCnpj(),
                loja.getLojaSegmentos(),
                null,
                listaProduto,
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
                .statusLoja(StatusLoja.ATIVA)
                .build();
    }

}
