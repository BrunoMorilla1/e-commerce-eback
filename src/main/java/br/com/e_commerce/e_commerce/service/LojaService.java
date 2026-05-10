package br.com.e_commerce.e_commerce.service;

import br.com.e_commerce.e_commerce.dto.requisicao.LojaDtoRequisicao;
import br.com.e_commerce.e_commerce.dto.resposta.LojaDtoResposta;
import br.com.e_commerce.e_commerce.mapper.LojaMapper;
import br.com.e_commerce.e_commerce.repository.LojaRepository;
import br.com.e_commerce.e_commerce.util.LojaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class LojaService {

    @Autowired
    private LojaRepository repository;

    @Transactional
    public LojaDtoResposta criarLoja(LojaDtoRequisicao lojaDtoRequisicao){
        var converter = LojaMapper.paraEntity(lojaDtoRequisicao);
        var cnpj = LojaUtil.cnpjNumerico(lojaDtoRequisicao.cnpj());
        converter.setCnpj(cnpj);
        var lojaSalva = repository.save(converter);
        log.debug("Loja criada com sucesso.");
        return LojaMapper.paraRespostaDto(lojaSalva);
    }

    @Transactional(readOnly = true)
    public List<LojaDtoResposta> listaDeLojas(){
        var lojas = repository.findAll();
        return lojas.stream()
                .map(LojaMapper::paraRespostaDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public LojaDtoResposta buscarLojaPorid(Long id){
        return repository.findById(id)
                .map(LojaMapper::paraRespostaDto)
                .orElseThrow(()-> new RuntimeException("O id informado não foi localizado em nosso banco de dados"));
    }

    @Transactional
    public LojaDtoResposta atualizarLoja(Long id, LojaDtoRequisicao lojaDtoRequisicao){
        var loja = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("O id informado não foi encontrado em nosso banco de dados"));

        if (!lojaDtoRequisicao.cnpj().isEmpty()){
            loja.setCnpj(lojaDtoRequisicao.cnpj());
        }
        if (!lojaDtoRequisicao.nome().isEmpty()){
            loja.setNome(lojaDtoRequisicao.nome());
        }

        if (lojaDtoRequisicao.lojaSegmentos() != null){
            loja.setLojaSegmentos(lojaDtoRequisicao.lojaSegmentos());

        }
        var lojaSalva = repository.save(loja);
        return LojaMapper.paraRespostaDto(lojaSalva);
    }

    @Transactional
    public String deletarLoja(Long id){
        var loja = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("O id informado não foi encontrado em nosso banco de dados."));
        repository.delete(loja);
        return "Usuario deletado com sucesso.";
    }
}
