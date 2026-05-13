package br.com.e_commerce.e_commerce.dto.resposta;

public record RespostaErro(
        String code,
        String mendagem,
        String detalhes
) {
}
