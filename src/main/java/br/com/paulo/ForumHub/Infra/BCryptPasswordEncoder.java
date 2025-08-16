package br.com.paulo.ForumHub.Infra;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCryptPasswordEncoder {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder().passwordEncoder();
    }
}
