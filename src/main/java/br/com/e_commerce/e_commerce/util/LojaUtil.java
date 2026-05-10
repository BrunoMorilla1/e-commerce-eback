package br.com.e_commerce.e_commerce.util;

import br.com.e_commerce.e_commerce.exceptions.ErroConverterCnpjException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class LojaUtil {

    public String cnpjNumerico(String cnpj){
        var cnpjConvertido = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.matches("\\d+")){
            return cnpjConvertido;
        }
        throw new ErroConverterCnpjException("O campo CNPJ precisa ser somente numero, o CNPJ digitado esta invalido");
    }

}
