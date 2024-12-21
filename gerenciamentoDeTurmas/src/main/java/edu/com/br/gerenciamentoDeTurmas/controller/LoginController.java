package edu.com.br.gerenciamentoDeTurmas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("errorMsg", "Seu nome de usuário e senha são inválidos.");
        }
        if (logout != null) {
            model.addAttribute("msg", "Você foi desconectado com sucesso.");
        }
        return "login";
    }
}
