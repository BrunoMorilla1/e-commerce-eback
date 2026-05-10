package br.com.e_commerce.e_commerce.service;

import br.com.e_commerce.e_commerce.dto.requisicao.ProdutoDtoRequisicao;
import br.com.e_commerce.e_commerce.dto.resposta.ProdutoDtoResposta;
import br.com.e_commerce.e_commerce.mapper.ProdutoMapper;
import br.com.e_commerce.e_commerce.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public ProdutoDtoResposta criarProduto(ProdutoDtoRequisicao requisicao){
        var produto = ProdutoMapper.paraEntidade(requisicao);
        repository.save(produto);
        log.debug("Produto criado");
        return ProdutoMapper.paraRespostaDto(produto);
    }

    @Transactional(readOnly = true)
    public List<ProdutoDtoResposta> listaDeProdutos(){
        var produto = repository.findAll();
        return produto
                .stream()
                .map(ProdutoMapper::paraRespostaDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public ProdutoDtoResposta buscarProdutoPorId(Long id){
        return repository.findById(id)
                .map(ProdutoMapper::paraRespostaDto)
                .orElseThrow(()-> new RuntimeException("O id informado não existe em nosso banco de dados"));
    }

    @Transactional
    public ProdutoDtoResposta atualizarProduto(long id, ProdutoDtoRequisicao requisicao){
        var produto = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("O id do produto informado não existe em nosso banco de dados"));

        if (!requisicao.nome().isEmpty()){
            produto.setNome(requisicao.nome());
        }
        if (!requisicao.descricao().isEmpty()){
            produto.setDescricao(requisicao.descricao());
        }
        produto.setValor(requisicao.valor());
        if (requisicao.valor() != null){
            produto.setValor(requisicao.valor());
        }
        if (requisicao.statusProduto() != null){
            produto.setStatusProduto(requisicao.statusProduto());
        }
        var produtoSalvo = repository.save(produto);
        return ProdutoMapper.paraRespostaDto(produtoSalvo);
    }

    @Transactional
    public String deletarProduto(Long id){
        var produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("O id do produto informado não existe em nosso banco de dados"));
        repository.delete(produto);
        return "Produto deletado com sucesso";
    }
}
