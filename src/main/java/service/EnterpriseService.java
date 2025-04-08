package service;


import entity.Enterprise;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EnterpriseRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public List<Enterprise> getAllEnterprises() {
        return enterpriseRepository.findAll();
    }

    public Optional<Enterprise> getEnterpriseById(Long id) {
        return enterpriseRepository.findById(id);
    }

    public Enterprise saveEnterprise(Enterprise enterprise) {
        return (Enterprise) enterpriseRepository.save(enterprise);
    }

    public void deleteEnterprise(Long id) {
        enterpriseRepository.deleteById(id);
    }
}