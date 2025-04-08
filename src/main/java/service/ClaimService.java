package service;

import entity.Claim;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ClaimRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClaimService {

    private final ClaimRepository claimRepository;

    private final Claim claim;

    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    public Optional<Claim> getClaimById(Long id) {
        return claimRepository.findById(id);
    }

    public Claim saveClaim(Claim claim) {
        return (Claim) claimRepository.save(claim);
    }

    public void deleteClaim(Long id) {
        claimRepository.deleteById(id);
    }
}