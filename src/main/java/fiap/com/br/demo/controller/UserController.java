package fiap.com.br.demo.controller;

import fiap.com.br.demo.dto.UserDTO;
import fiap.com.br.demo.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import fiap.com.br.demo.service.UserService;
import java.util.UUID;


@Controller
@RequestMapping("/user")
@AllArgsConstructor
@Log
public class UserController {

    @Autowired
    private UserService service;
    private UserRepository repository;


    @GetMapping
    public String listUser(Model model) {
        var user = service.getUser();
        user.forEach(u -> log.info("ID do usuário: " + u.getId()));
        model.addAttribute("user", service.getUser());
        return "user";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Mongo conectado";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new UserDTO());
        return "userformulario";
    }

    @PostMapping("/save")
    public String salveUser(
            @Valid @ModelAttribute("user") UserDTO userDTO,
            BindingResult bindingResult,
            Model model
    ){
        if (bindingResult.hasErrors()) {
            log.warning("Erros de validacao ao salvar usuario:");
            bindingResult.getAllErrors().forEach(e -> log.warning(e.toString()));
            model.addAttribute("user", userDTO);
            return "userformulario";
        }
        log.info("Salvando usuario: " + userDTO);
        service.save(userDTO);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable String id, Model model) {
        UserDTO user = service.findById(id);
        model.addAttribute("user", user);
        return "userformulario";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        service.deleteById(id);
        return "redirect:/user";
    }
}
