package repository;

import entity.Claim;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import java.util.UUID;

public interface ClaimRepository extends MongoRepository<Claim, String> {

    Optional<Claim> findByUuid(UUID uuid);

}
