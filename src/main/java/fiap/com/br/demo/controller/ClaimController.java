package fiap.com.br.demo.controller;

import fiap.com.br.demo.entity.Claim;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import fiap.com.br.demo.service.ClaimService;

import java.util.List;



@RestController
@RequestMapping("/claim")
@AllArgsConstructor
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping("/list")
    public String listClaims(Model model) {
        List<Claim> claims = claimService.getAllClaims();
        model.addAttribute("claims", claims);
        return "claim-list";
    }

    @GetMapping("/form")
    public String showClaimForm(Model model) {
        model.addAttribute("claim", new Claim());
        return "claim-form";
    }

    @PostMapping("/save")
    public String saveClaim(@ModelAttribute Claim claim) {
        claimService.saveClaim(claim);
        return "redirect:/claim/list";
    }

    @GetMapping("/edit/{id}")
    public String editClaim(@PathVariable Long id, Model model) {
        Claim claim = claimService.getClaimById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reclamação inválida: " + id));
        model.addAttribute("claim", claim);
        return "claim-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteClaim(@PathVariable Long id) {
        claimService.deleteClaim(id);
        return "redirect:/claim/list";
    }
}