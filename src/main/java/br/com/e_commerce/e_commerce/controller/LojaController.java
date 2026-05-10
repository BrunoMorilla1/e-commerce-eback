package br.com.e_commerce.e_commerce.controller;

import br.com.e_commerce.e_commerce.dto.requisicao.LojaDtoRequisicao;
import br.com.e_commerce.e_commerce.dto.resposta.LojaDtoResposta;
import br.com.e_commerce.e_commerce.service.LojaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/V1-loja")
@RestController
@Slf4j
@RequiredArgsConstructor
public class LojaController {

    @Autowired
    private LojaService lojaService;

    @PostMapping("/salvar")
    public ResponseEntity<LojaDtoResposta> criarLoja(@RequestBody @Valid LojaDtoRequisicao lojaDtoRequisicao){
            var loja = lojaService.criarLoja(lojaDtoRequisicao);
            return ResponseEntity.status(HttpStatus.CREATED).body(loja);
    }

    @GetMapping("/consultar")
    public ResponseEntity<List<LojaDtoResposta>> listaDeLojas(){
        var lojas = lojaService.listaDeLojas();
        if (!lojas.isEmpty()){
            return ResponseEntity.ok().body(lojas);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<LojaDtoResposta> buscarLojaPorid(@PathVariable(value = "id")Long id){
        if (id == null){
        return ResponseEntity.notFound().build();
        }

        var loja = lojaService.buscarLojaPorid(id);
        return ResponseEntity.ok().body(loja);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<LojaDtoResposta> atualizarLoja(@PathVariable(value = "id") Long id,
                                                         @RequestBody @Valid LojaDtoRequisicao lojaDtoRequisicao){
        var loja = lojaService.atualizarLoja(id, lojaDtoRequisicao);
        return ResponseEntity.ok().body(loja);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarLoja(@PathVariable(value = "id")Long id){
        var loja = lojaService.deletarLoja(id);
        return ResponseEntity.ok().body("Usuario deletado com sucesso!");
    }

}
