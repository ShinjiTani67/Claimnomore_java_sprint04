package fiap.com.br.demo.controller;

import fiap.com.br.demo.dto.ClaimDTO;
import fiap.com.br.demo.entity.Claim;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import fiap.com.br.demo.service.ClaimService;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/claim")
@AllArgsConstructor
@Controller
@Log
public class ClaimController {

    private ClaimService claimService;

    @GetMapping("/new")
    public String newClaim(Model model){
        model.addAttribute("claim", new ClaimDTO());
        return "claim/formulario";
    }

    @PostMapping("/save")
    public String saveClaim(
            @Valid @ModelAttribute("claim") ClaimDTO claimDTO,
            BidingResult bidingResult,
            Model model
    ){
        if (bidingResult.hasErrors()){
            log.warn("Erro de validacao:");
            bindingResult.getAllErrors().forEach(e -> log.warn(e.toString()));
            model.addAttribute("claim", claimDTO);
            return "claim/formulario";
        }
        log.info("Salvando claim: {}", claimDTO);
        service.save(claimDTO);
        return "redirect:/claim";
    }

    @GetMapping("/editar/{id}")
    public String delete(@PathVariable UUID){
        service.deletarPorIdI(uuid);
        return "redirect:/claim";
    }
}