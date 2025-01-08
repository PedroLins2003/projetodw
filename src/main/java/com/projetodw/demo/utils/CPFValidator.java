package com.projetodw.demo.utils;

import org.springframework.stereotype.Component;

@Component
public class CPFValidator{

    // Método para validar o CPF (estático)
    public static boolean isValidCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");  // Remove qualquer caractere que não seja número

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se o CPF é uma sequência de números repetidos (exemplo: 111.111.111-11)
        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || 
            cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || 
            cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || 
            cpf.equals("99999999999")) {
            return false;
        }

        // Verifica os dois dígitos verificadores
        int digito1 = calcularDigito(cpf.substring(0, 9), 10);
        int digito2 = calcularDigito(cpf.substring(0, 9) + digito1, 11);

        return cpf.equals(cpf.substring(0, 9) + digito1 + digito2);
    }

    // Método para calcular o dígito verificador
    private static int calcularDigito(String base, int peso) {
        int soma = 0;
        for (int i = 0; i < base.length(); i++) {
            soma += Character.getNumericValue(base.charAt(i)) * peso--;
        }
        int digito = 11 - (soma % 11);
        return digito > 9 ? 0 : digito;
    }
}



