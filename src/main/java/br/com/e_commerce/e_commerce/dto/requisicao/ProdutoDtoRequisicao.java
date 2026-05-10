package br.com.e_commerce.e_commerce.dto.requisicao;

import br.com.e_commerce.e_commerce.enums.StatusProduto;

import java.math.BigDecimal;

public record ProdutoDtoRequisicao(

        String nome,
        String descricao,
        int quantidade,
        BigDecimal valor,
        StatusProduto statusProduto,
        LojaDtoRequisicao cnpj){

}
