package fiap.com.br.demo.controller;


import fiap.com.br.demo.entity.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fiap.com.br.demo.repository.EnterpriseRepository;


import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @GetMapping
    public List<Enterprise> getAllUser() {
        return enterpriseRepository.findAll();
    }

    @PostMapping
    public Enterprise createEnterprise(@RequestBody Enterprise enterprise) {
        return (Enterprise) enterpriseRepository.save(enterprise);
    }
}