package br.com.e_commerce.e_commerce.dto.requisicao;
import br.com.e_commerce.e_commerce.enums.LojaSegmentos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;


public record LojaDtoRequisicao(

        @NotBlank
        @Size(min = 3, max = 15, message = "O nome deve estar preenchido de 3 a 15 letras.")
        String nome,

        @CNPJ
        @NotBlank
        String cnpj,

        @NotBlank
        LojaSegmentos lojaSegmentos
) {


}
