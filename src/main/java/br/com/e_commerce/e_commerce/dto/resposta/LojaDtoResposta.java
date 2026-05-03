package br.com.e_commerce.e_commerce.dto.resposta;

import br.com.e_commerce.e_commerce.entity.ProdutoEntity;
import br.com.e_commerce.e_commerce.entity.UsuarioEntity;
import br.com.e_commerce.e_commerce.enums.LojaSegmentos;

import java.time.LocalDateTime;
import java.util.List;

public record LojaDtoResposta(
    Long id,

    String nome,

    String cnpj,

    LojaSegmentos lojaSegmentos,

    UsuarioEntity usuario,

    List<ProdutoEntity> produto,

    LocalDateTime criadoEm,

    LocalDateTime atualizadoEm) {
}
