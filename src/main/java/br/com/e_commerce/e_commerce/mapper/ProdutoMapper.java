package br.com.e_commerce.e_commerce.mapper;

import br.com.e_commerce.e_commerce.dto.requisicao.ProdutoDtoRequisicao;
import br.com.e_commerce.e_commerce.dto.resposta.ProdutoDtoResposta;
import br.com.e_commerce.e_commerce.entity.ProdutoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProdutoMapper {

    public static ProdutoDtoResposta paraRespostaDto(ProdutoEntity produto){
        log.debug("Mapper[Produto] - Convertendo entidade para resposta. produtoId={}", produto.getId());
        return new ProdutoDtoResposta(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getQuantidade(),
                produto.getValor(),
                produto.getLoja(),
                produto.getStatusProduto(),
                produto.getCriadoEm(),
                produto.getAtualizadoEm()
        );
    }

    public static ProdutoEntity paraEntidade(ProdutoDtoRequisicao produto){
        log.debug("Mapper[Produto] - Convertendo DTO para entidade.");
        return ProdutoEntity.builder()
                .nome(produto.nome())
                .descricao(produto.descricao())
                .quantidade(produto.quantidade())
                .valor(produto.valor())
                .statusProduto(produto.statusProduto())
                .build();
    }
}
