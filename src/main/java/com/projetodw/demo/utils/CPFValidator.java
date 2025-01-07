package com.projetodw.demo.utils;

import org.springframework.stereotype.Component;

@Component
public class CPFValidator {
    
    public static boolean isValidCPF(String cpf) {
        if (cpf == null) {
            return false;
        }
        
        // Remove pontos e traços
        cpf = cpf.replaceAll("\\.|-", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11 || !cpf.matches("\\d{11}")) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (caso inválido como 111.111.111-11)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Cálculo do primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit >= 10) {
            firstDigit = 0;
        }

        // Cálculo do segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit >= 10) {
            secondDigit = 0;
        }

        // Verifica se os dígitos calculados correspondem aos dígitos informados
        return cpf.charAt(9) - '0' == firstDigit && cpf.charAt(10) - '0' == secondDigit;
    }

    public static void main(String[] args) {
        String[] cpfs = {
            "123.456.789-09",
            "111.111.111-11",
            "529.982.247-25",
            "000.000.000-00",
            "935.411.347-80"
        };

        for (String cpf : cpfs) {
            System.out.println("CPF " + cpf + " é válido? " + isValidCPF(cpf));
        }
    }
}

