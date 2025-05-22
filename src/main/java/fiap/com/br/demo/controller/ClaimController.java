package fiap.com.br.demo.controller;

import fiap.com.br.demo.dto.ClaimDTO;
import fiap.com.br.demo.dto.UserDTO;
import fiap.com.br.demo.repository.ClaimRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import fiap.com.br.demo.service.ClaimService;

import java.util.UUID;


@Controller
@RequestMapping("/claim")
@AllArgsConstructor
@Log
public class ClaimController {

    private ClaimService service;
    private ClaimRepository repository;

    @GetMapping
    public String listClaim(Model model){
        var claim = service.getAllClaims();
        claim.forEach(u -> log.info("ID do usuário: " + u.getId()));
        model.addAttribute("claim", service.getAllClaims());
        return "claim";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Mongo conectado";
    }

    @GetMapping("/new")
    public String newClaim(Model model){
        model.addAttribute("claim", new ClaimDTO());
        return "claimformulario";
    }

    @PostMapping("/save")
    public String saveClaim(
            @Valid @ModelAttribute("claim") ClaimDTO claimDTO,
            BindingResult bindingResult,
            Model model
    ){
        if (bindingResult.hasErrors()){
            log.warning("Erro de validacao:");
            bindingResult.getAllErrors().forEach(e -> log.warning(e.toString()));
            model.addAttribute("claim", claimDTO);
            return "claimformulario";
        }
        log.info("Salvando claim: {}" + claimDTO);
        service.save(claimDTO);
        return "redirect:/claim";
    }

    @GetMapping("/edit/{id}")
    public String editClaim(@PathVariable String id, Model model) {
        ClaimDTO claim = service.findById(id);
        model.addAttribute("claim", claim);
        return "claimformulario";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        service.deleteById(id);
        return "redirect:/claim";
    }
}
