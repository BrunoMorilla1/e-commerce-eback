package br.com.e_commerce.e_commerce.controller;

import br.com.e_commerce.e_commerce.dto.requisicao.UsuarioRequisicao;
import br.com.e_commerce.e_commerce.dto.resposta.UsuarioResposta;
import br.com.e_commerce.e_commerce.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1-usuarios")
@Slf4j
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;


    @PostMapping("/salvar")
    public ResponseEntity<UsuarioResposta> criarUsuario(@RequestBody @Valid UsuarioRequisicao usuarioRequisicao) {
        var usuario = usuarioService.criarUsuario(usuarioRequisicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);

    }

    @GetMapping("/consultar")
    public ResponseEntity<List<UsuarioResposta>> listaDeUsuarios() {
        try {
            var lista = usuarioService.listaDeUsuariosDTO();
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            log.error("Erro ao consultar usuários", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<UsuarioResposta> buscarPorId(@PathVariable Long id) {
        if (id == null)
            return ResponseEntity.badRequest().build();

        UsuarioResposta usuarioDto = usuarioService.buscarUsuarioPorId(id);
        if (usuarioDto == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(usuarioDto);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioResposta> atualizarUsuario(@PathVariable(value = "id") Long id,
                                                            @RequestBody @Valid UsuarioRequisicao requisicao) {
        var usuario = usuarioService.atualizarUsuario(id, requisicao);
        if (usuario == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable(value = "id")Long id){
        var texto = usuarioService.deletarUsuario(id);
        return ResponseEntity.ok().body(texto);
    }
}