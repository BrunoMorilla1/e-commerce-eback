package br.com.e_commerce.e_commerce.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class LojaUtil {

    public String cnpjNumerico(String cnpj) {
        var cnpjConvertido = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.matches("\\d+")) {
            return cnpjConvertido;
        }
        return null;

    }
}
