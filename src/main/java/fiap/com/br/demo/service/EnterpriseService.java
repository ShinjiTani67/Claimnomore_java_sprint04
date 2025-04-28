package fiap.com.br.demo.service;

import fiap.com.br.demo.dto.EnterpriseDTO;
import fiap.com.br.demo.entity.Enterprise;
import fiap.com.br.demo.entity.User;
import fiap.com.br.demo.repository.EnterpriseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EnterpriseService {

    private final EnterpriseRepository repository;

    private EnterpriseDTO convertToDTO(Enterprise enterprise) {
        EnterpriseDTO dto = new EnterpriseDTO();
        dto.setAdress(enterprise.getAdress());
        dto.setId(enterprise.getUuid());
        dto.setCnpj(enterprise.getCnpj());
        dto.setPhone(enterprise.getPhone());
        return dto;
    }

    private Enterprise convertToEntity(EnterpriseDTO dto) {
        Enterprise enterprise = new Enterprise();
        enterprise.setUuid(dto.getId());
        enterprise.setAdress(dto.getAdress());
        enterprise.setCnpj(dto.getCnpj());
        enterprise.setPhone(dto.getPhone());
        return enterprise;
    }

    public EnterpriseDTO save(EnterpriseDTO enterpriseDTO) {
        Enterprise enterprise = convertToEntity(enterpriseDTO);
        enterprise = repository.save(enterprise);
        return convertToDTO(enterprise);
    }

    public List<EnterpriseDTO> getEnterprise() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deletarPorId(UUID uuid) {

        repository.deleteById(uuid);
    }

    public EnterpriseDTO findByUuid(UUID uuid) {

        Optional<Enterprise> byId = repository.findById(uuid);
        if (byId.isPresent())
            return convertToDTO(byId.get());{
        }
        throw new RuntimeException("Usuario com id" + uuid + "nao encontrado");
    }
}
