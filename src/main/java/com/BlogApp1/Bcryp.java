package com.BlogApp1;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Bcryp {
    public static void main(String[] args) {

        PasswordEncoder e = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2A);
        System.out.println(e.encode("testing"));
    }
}
