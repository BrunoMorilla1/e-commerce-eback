package br.com.e_commerce.e_commerce.dto.requisicao;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record UsuarioRequisicao(

        @NotBlank
        @Size(min = 3, max = 15, message = "O nome deve conter entre 3 a 15 letras.")
        String nome,

        @CPF
        @NotBlank
        String cpf,

        @NotBlank
        String dataDeNascimento,

        @NotBlank
        @Email
        String email){
}
