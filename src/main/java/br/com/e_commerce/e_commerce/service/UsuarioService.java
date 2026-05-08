package br.com.e_commerce.e_commerce.service;

import br.com.e_commerce.e_commerce.dto.requisicao.UsuarioRequisicao;
import br.com.e_commerce.e_commerce.dto.resposta.UsuarioResposta;
import br.com.e_commerce.e_commerce.entity.UsuarioEntity;
import br.com.e_commerce.e_commerce.mapper.UsuarioMapper;
import br.com.e_commerce.e_commerce.repository.UsuarioRepository;
import br.com.e_commerce.e_commerce.util.UsuarioUtill;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private final UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;


    @Transactional
    public UsuarioResposta criarUsuario(UsuarioRequisicao usuarioRequisicao){
       var usuario = UsuarioMapper.paraEntidade(usuarioRequisicao);
       var cpf = UsuarioUtill.converterCpfSalvar(usuarioRequisicao.cpf());
       usuario.setCpf(cpf);
       var usuarioSalvo = repository.save(usuario);
       log.debug("usuario criado.");
       return UsuarioMapper.paraRespostaDTO(usuarioSalvo);
    }

    @Transactional(readOnly = true)
    public List<UsuarioResposta> listaDeUsuariosDTO() {
        List<UsuarioEntity> usuarios = repository.findAll();
        return usuarios.stream()
                .map(UsuarioMapper::paraRespostaDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public UsuarioResposta buscarUsuarioPorId(Long id) {
        return repository.findById(id)
                .map(UsuarioMapper::paraRespostaDTO)
                .orElse(null);
    }

    @Transactional
    public UsuarioResposta atualizarUsuario(Long id, UsuarioRequisicao requisicao) {
        var usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id informado esta invalido ou não existe"));

        if (!requisicao.nome().isEmpty()) {
            usuario.setNome(requisicao.nome());
        }
        if (!requisicao.cpf().isEmpty()) {
            usuario.setCpf(UsuarioUtill.converterCpfSalvar(requisicao.cpf()));
        }
        if (!requisicao.dataDeNascimento().isEmpty()) {
            usuario.setDataDeNascimento(requisicao.dataDeNascimento());
        }
        if (!requisicao.email().isEmpty()) {
            usuario.setEmail(requisicao.email());
        }
        var usuarioSalvo = repository.save(usuario);
        log.debug("Usuario atualizado");

        return UsuarioMapper.paraRespostaDTO(usuarioSalvo);
    }

    @Transactional
    public String deletarUsuario(Long id){
        var usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id informado esta invalido ou não existe"));
        repository.delete(usuario);
        log.info("Usuario deletado");
        return "Usuario deletado com sucesso!";
    }
}
