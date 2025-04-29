package fiap.com.br.demo.controller;


import fiap.com.br.demo.entity.Dentist;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import fiap.com.br.demo.service.DentistService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dentist")
@AllArgsConstructor
@Log
public class DentistController {

    @Autowired
    private DentistService dentistService;

    @GetMapping("/list")
    public String listDentists(Model model) {
        List<Dentist> dentists = dentistService.getAllDentists();
        model.addAttribute("dentists", dentists);
        return "dentista.html"; 
    }

    @GetMapping("/form")
    public String showDentistForm(Model model) {
        model.addAttribute("dentist", new Dentist());
        return "dentistaformulario.html"; 
    }

    @PostMapping("/save")
    public String saveDentist(@ModelAttribute Dentist dentist) {
        dentistService.saveDentist(dentist);
        return "redirect:/dentist/list";
    }

    @GetMapping("/edit/{id}")
    public String editDentist(@PathVariable Long id, Model model) {
        Dentist dentist = dentistService.getDentistById(id)
                .orElseThrow(() -> new IllegalArgumentException("Dentista inválido: " + id));
        model.addAttribute("dentist", dentist);
        return "dentistaformulario.html"; 
    }

    @GetMapping("/delete/{id}")
    public String deleteDentist(@PathVariable Long id) {
        dentistService.deleteDentist(id);
        return "redirect:/dentist/list"; 
    }
}