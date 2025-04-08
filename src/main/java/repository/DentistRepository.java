package repository;

import entity.Claim;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import java.util.UUID;


public interface DentistRepository extends MongoRepository {
    Optional<Claim> findByUuid(UUID uuid);
}
