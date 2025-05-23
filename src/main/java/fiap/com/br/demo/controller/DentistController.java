package fiap.com.br.demo.controller;


import fiap.com.br.demo.dto.ClaimDTO;
import fiap.com.br.demo.dto.DentistDTO;
import fiap.com.br.demo.repository.DentistRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import fiap.com.br.demo.service.DentistService;

import java.util.UUID;


@Controller
@RequestMapping("/dentist")
@AllArgsConstructor
@Log
public class DentistController {

    private DentistService service;
    private DentistRepository repository;

    @GetMapping
    public String listDentist(Model model){
        var dentist = service.getAllDentist();
        dentist.forEach(u -> log.info("ID do dentist: " + u.getId()));
        model.addAttribute("dentist", service.getAllDentist());
        return "dentist";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {

        return "Mongo conectado";
    }

    @GetMapping("/new")
    public String newDentist(Model model){
        model.addAttribute("dentist", new DentistDTO());
        return "dentistformulario";
    }

    @PostMapping("/save")
    public String saveDentist(
            @Valid @ModelAttribute("dentist") DentistDTO dentistDTO,
            BindingResult bindingResult,
            Model model
    ){
        if (bindingResult.hasErrors()) {
            log.warning("Erros de validacao ao salvar carro:");
            bindingResult.getAllErrors().forEach(e -> log.warning(e.toString()));
            model.addAttribute("dentist", dentistDTO);
            return "dentistformulario";
        }
        log.info("Salvando dentista: " + dentistDTO);
        service.save(dentistDTO);
        return "redirect:/dentist";
    }

    @GetMapping("/edit/{id}")
    public String editDentist(@PathVariable String id, Model model) {
        try {
            DentistDTO dentistDTO = service.findById(id);
            model.addAttribute("dentist", dentistDTO);
            return "dentistformulario";
        } catch (RuntimeException e) {
            log.warning("Erro ao carregar sinistro para edição: " + e.getMessage());
            return "redirect:/dentist";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        service.deleteById(id);
        return "redirect:/dentist";
    }
}
