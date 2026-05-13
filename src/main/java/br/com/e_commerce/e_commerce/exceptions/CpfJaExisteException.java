package br.com.e_commerce.e_commerce.exceptions;

public class CpfJaExisteException extends RuntimeException {
    public CpfJaExisteException(String cpf) {
        super("Já existe um usuário cadastrado com o CPF: " + cpf);
    }
}
