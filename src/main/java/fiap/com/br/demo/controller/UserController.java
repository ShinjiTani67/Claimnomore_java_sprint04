package fiap.com.br.demo.controller;

import fiap.com.br.demo.dto.UserDTO;
import fiap.com.br.demo.entity.User;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import fiap.com.br.demo.service.UserService;

import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/user")
@AllArgsConstructor
@Log
public class UserController {

    private UserService service;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Mongo conectado";
    }
    
    @GetMapping
    public String listClaims(Model model) {
        model.addAttribute("claims", service.findAll());
        return "home"; 
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new UserDTO());
        return "user/formulario";
    }

    @PostMapping("new")
    public String salveUser(
            @Valid @ModelAttribute("user") UserDTO userDTO,
            BindingResult bindingResult,
            Model model
    ){
        if (bindingResult.hasErrors()) {
            log.warning("Erros de validacao ao salvar usuario:");
            bindingResult.getAllErrors().forEach(e -> log.warning(e.toString()));
            model.addAttribute("user", userDTO);
            return "user/formulario";
        }
        log.info("Salvando usuario: " + userDTO);
        service.save(userDTO);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String delete(@PathVariable UUID id){
        service.deleteById(id);
        return "redirect:/user";
    }
}
