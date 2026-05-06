package br.com.e_commerce.e_commerce.util;

import br.com.e_commerce.e_commerce.dto.resposta.UsuarioResposta;
import br.com.e_commerce.e_commerce.entity.UsuarioEntity;
import br.com.e_commerce.e_commerce.exceptions.ConverterCpfErroException;
import br.com.e_commerce.e_commerce.repository.UsuarioRepository;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class UsuarioUtill {

    public String converterCpfSalvar(String cpf){
        var cpfConvertido = cpf.replaceAll("[^0-9]", "");

        if(!cpf.matches("\\d+")){
            return cpfConvertido;
        }
        throw new ConverterCpfErroException("O campo CPF precisa conter somente numeros");
        }

    public String cpfResposta(UsuarioResposta usuarioResposta){
        var cpf = usuarioResposta.cpf();

        if (cpf != null && cpf.length() == 11){
           return cpf.substring(0,3) + "."
                   + cpf.substring(3,6) + "."
                   + cpf.substring(6,9) + "-"
                   + cpf.substring(9,11);
        }
        return cpf;
}

}