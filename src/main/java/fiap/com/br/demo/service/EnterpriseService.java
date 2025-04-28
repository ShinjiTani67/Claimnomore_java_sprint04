package fiap.com.br.demo.service;


import fiap.com.br.demo.entity.Enterprise;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fiap.com.br.demo.repository.EnterpriseRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public List<Enterprise> getAllEnterprises() {
        return enterpriseRepository.findAll();
    }

    public Optional<Enterprise> getEnterpriseById(Long id) {
        return enterpriseRepository.findById(String.valueOf(id));
    }

    public Enterprise saveEnterprise(Enterprise enterprise) {
        return (Enterprise) enterpriseRepository.save(enterprise);
    }

    public void deleteEnterprise(Long id) {
        enterpriseRepository.deleteById(String.valueOf(id));
    }
}