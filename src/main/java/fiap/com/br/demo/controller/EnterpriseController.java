package fiap.com.br.demo.controller;


import fiap.com.br.demo.dto.EnterpriseDTO;
import fiap.com.br.demo.service.EnterpriseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import fiap.com.br.demo.repository.EnterpriseRepository;


@Controller
@RequestMapping("/enterprise")
@AllArgsConstructor
@Log
public class EnterpriseController {

    private EnterpriseService service;
    private EnterpriseRepository repository;

    @GetMapping
    public String listEnterprise(Model model){
        var enterprise = service.getEnterprise();
        enterprise.forEach(u -> log.info("ID do usuário: " + u.getId()));
        model.addAttribute("enterprises", service.getEnterprise());
        return "enterprise";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {

        return "Mongo conectado";
    }

    @GetMapping("/new")
    public String newEnterprise(Model model){
        model.addAttribute("enterprise", new EnterpriseDTO());
        return "enterpriseformulario";
    }

    @PostMapping("/save")
    public String saveEnterprise(
            @Valid @ModelAttribute("enterprise") EnterpriseDTO enterpriseDTO,
            BindingResult bindingResult,
            Model model
    ){
        if (bindingResult.hasErrors()) {
            log.warning("Erros de validacao ao salvar empresa:");
            bindingResult.getAllErrors().forEach(e -> log.warning(e.toString()));
            model.addAttribute("enterprise", enterpriseDTO);
            return "enterpriseformulario";
        }
        log.info("Salvando empresa: " + enterpriseDTO);
        service.save(enterpriseDTO);
        return "redirect:/enterprise";
    }

    @GetMapping("/edit/{id}")
    public String editClaim(@PathVariable String id, Model model) {
        try {
            EnterpriseDTO enterpriseDTO = service.findById(id);
            model.addAttribute("enterprise", enterpriseDTO);
            return "enterpriseformulario";

        } catch (RuntimeException e) {
            log.warning("Erro ao carregar sinistro para edição: " + e.getMessage());
            return "redirect:/enterprise";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        service.deleteById(id);
        return "redirect:/enterprise";
    }
}
