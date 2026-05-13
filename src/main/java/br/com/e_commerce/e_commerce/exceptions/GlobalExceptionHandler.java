package br.com.e_commerce.e_commerce.exceptions;

import br.com.e_commerce.e_commerce.dto.requisicao.RequisicaoErro;
import br.com.e_commerce.e_commerce.dto.resposta.RespostaErro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(AcessoNegadoException.class)
    public ResponseEntity<RequisicaoErro<Void>> tratarAcessoNegado(AcessoNegadoException ex){
        log.warn("Acesso negado: {}", ex.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new RequisicaoErro<>(
                        false,
                        null,
                        new RespostaErro(
                                "ACESSO_NEGADO",
                                ex.getMessage(),
                                null
                        )
                ));
    }

    @ExceptionHandler(CpfJaExisteException.class)
    public ResponseEntity<RequisicaoErro<Void>> tratarCpfJaExiste(CpfJaExisteException ex){
        log.warn("CPF já cadastrado: {}", ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new RequisicaoErro<>(
                        false,
                        null,
                        new RespostaErro(
                                "CPF_JA_CADASTRADO",
                                ex.getMessage(),
                                null
                        )
                ));
    }

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<RequisicaoErro<Void>> tratarUsuarioNaoEncontrado(UsuarioNaoEncontradoException ex){
        log.warn("Usuário não encontrado: {}", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new RequisicaoErro<>(
                        false,
                        null,
                        new RespostaErro(
                                "USUARIO_NAO_ENCONTRADO",
                                ex.getMessage(),
                                null)
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RequisicaoErro<Void>> tratarErroGenerico(Exception ex){
        log.warn("Erro inesperado", ex);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new RequisicaoErro<>(
                        false,
                        null,
                        new RespostaErro(
                                "ERRO_INTERNO",
                                "Ocorreu um erro interno no servidor",
                                null
                        )
                ));
    }
}
