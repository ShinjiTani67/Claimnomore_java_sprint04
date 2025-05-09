package fiap.com.br.demo.controller;

import fiap.com.br.demo.dto.ClaimDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import fiap.com.br.demo.service.ClaimService;

import java.util.UUID;


@RestController
@RequestMapping("/claim")
@AllArgsConstructor
@Log
public class ClaimController {

    private ClaimService service;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "Mongo conectado";
    }

    @GetMapping("/new")
    public String newClaim(Model model){
        model.addAttribute("claim", new ClaimDTO());
        return "claim/formulario";
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
            return "claim/formulario";
        }
        log.info("Salvando claim: {}" + claimDTO);
        service.save(claimDTO);
        return "redirect:/claim";
    }

    @GetMapping("/editar/{id}")
    public String delete(@PathVariable UUID id){
        service.deleteById(id);
        return "redirect:/claim";
    }
}
