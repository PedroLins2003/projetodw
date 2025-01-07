package com.projetodw.demo.utils;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class NTelefoneValidator {

    // Regex para validar números no formato (XX) XXXXX-XXXX ou (XX) XXXX-XXXX
    private static final String PHONE_REGEX = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$";

    private static final Pattern pattern = Pattern.compile(PHONE_REGEX);

    public static boolean isValidNtelefone(String NTelefone) {
        if (NTelefone == null || NTelefone.isEmpty()) {
            return false;
        }
        return pattern.matcher(NTelefone).matches();
    }
}

