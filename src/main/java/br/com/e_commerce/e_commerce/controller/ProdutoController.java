package br.com.e_commerce.e_commerce.controller;

import br.com.e_commerce.e_commerce.dto.requisicao.ProdutoDtoRequisicao;
import br.com.e_commerce.e_commerce.dto.resposta.ProdutoDtoResposta;
import br.com.e_commerce.e_commerce.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/V1-produto")
@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/salvar")
    public ResponseEntity<ProdutoDtoResposta> criarProduto(@RequestBody @Valid ProdutoDtoRequisicao produtoDtoRequisicao){
        var produto = produtoService.criarProduto(produtoDtoRequisicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ProdutoDtoResposta>> buscarTodosProdutos(){
        var produto = produtoService.listaDeProdutos();
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProdutoDtoResposta> buscarProdutoPorId(@PathVariable(value = "id")Long id){
        var produto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok().body(produto);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ProdutoDtoResposta> atualizarProduto(@PathVariable(value = "id")Long id,
                                                               @RequestBody @Valid ProdutoDtoRequisicao requisicao){
        var produto = produtoService.atualizarProduto(id, requisicao);
        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable(value = "id") Long id){
        var produto = produtoService.deletarProduto(id);
        return ResponseEntity.ok().body(produto);
    }
}
