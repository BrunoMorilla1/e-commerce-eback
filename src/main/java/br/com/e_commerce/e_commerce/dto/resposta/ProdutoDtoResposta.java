package br.com.e_commerce.e_commerce.dto.resposta;

import br.com.e_commerce.e_commerce.entity.LojaEntity;
import br.com.e_commerce.e_commerce.enums.StatusProduto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProdutoDtoResposta(

        Long id,
        String nome,
        String descricao,
        int quantidade,
        BigDecimal valor,
        LojaEntity loja,
        StatusProduto statusProduto,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm){

}
