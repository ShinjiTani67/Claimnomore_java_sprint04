package fiap.com.br.demo.service;

import fiap.com.br.demo.dto.ClaimDTO;
import fiap.com.br.demo.entity.Claim;
import fiap.com.br.demo.repository.ClaimRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClaimService {

    private final ClaimRepository repository;

    private ClaimDTO convertToDTO(Claim claim) {
        ClaimDTO dto = new ClaimDTO();
        dto.setId(claim.getId());
        dto.setClaimDate(claim.getClaimDate());
        dto.setDescription(claim.getDescription());
        return dto;
    }

    private Claim convertToEntity(ClaimDTO dto) {
        Claim claim = new Claim();
        claim.setId(dto.getId());
        claim.setClaimDate(dto.getClaimDate());
        claim.setDescription(dto.getDescription());
        return claim;
    }

    public ClaimDTO save(ClaimDTO claimDTO) {
        Claim claim = convertToEntity(claimDTO);

        if (claim.getId() == null || claim.getId().isBlank()) {
            claim.setId(UUID.randomUUID().toString());
        }

        claim = repository.save(claim);
        return convertToDTO(claim);
    }

    public List<ClaimDTO> getAllClaims() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public ClaimDTO findById(String id) {
        Optional<Claim> claim = repository.findById(id);
        if (claim.isPresent()) {
            return convertToDTO(claim.get());
        }
        throw new RuntimeException("Sinistro com id " + id + " não encontrado");
    }
}
