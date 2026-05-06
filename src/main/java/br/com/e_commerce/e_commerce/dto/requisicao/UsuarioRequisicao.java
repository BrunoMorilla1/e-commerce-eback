package br.com.e_commerce.e_commerce.dto.requisicao;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequisicao(

        @NotBlank
        @Size(min = 3, max = 15, message = "O nome deve conter entre 3 a 15 letras.")
        String nome,

        @NotBlank
        String cpf,

        @NotBlank
        String dataDeNascimento,

        @NotBlank
        @Email
        String email){
}
