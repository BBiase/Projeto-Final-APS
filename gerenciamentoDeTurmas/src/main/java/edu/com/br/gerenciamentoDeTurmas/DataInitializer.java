package edu.com.br.gerenciamentoDeTurmas;

import edu.com.br.gerenciamentoDeTurmas.model.Usuario;
import edu.com.br.gerenciamentoDeTurmas.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Component;

@Component
@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole("ADMIN");
            usuarioRepository.save(admin);

            Usuario gerente = new Usuario();
            gerente.setUsername("gerente");
            gerente.setPassword(passwordEncoder.encode("gerente123"));
            gerente.setRole("GERENTE");
            usuarioRepository.save(gerente);

            Usuario secretario = new Usuario();
            secretario.setUsername("secretario");
            secretario.setPassword(passwordEncoder.encode("secretario123"));
            secretario.setRole("SECRETARIO");
            usuarioRepository.save(secretario);
        };
    }
}
