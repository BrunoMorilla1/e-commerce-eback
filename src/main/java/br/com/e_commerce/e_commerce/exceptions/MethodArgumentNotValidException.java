package br.com.e_commerce.e_commerce.exceptions;

public class MethodArgumentNotValidException extends RuntimeException {
    public MethodArgumentNotValidException(String message) {
        super("Erro de validação");
    }
}
