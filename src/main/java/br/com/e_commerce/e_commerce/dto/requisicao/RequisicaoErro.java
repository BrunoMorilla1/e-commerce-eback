package br.com.e_commerce.e_commerce.dto.requisicao;


import br.com.e_commerce.e_commerce.dto.resposta.RespostaErro;

public record RequisicaoErro<T>(
        boolean sucesso,
        T data,
        RespostaErro erro
) {}
