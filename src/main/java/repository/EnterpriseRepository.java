package repository;

import entity.Claim;
import entity.Enterprise;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface EnterpriseRepository extends MongoRepository <Enterprise, String> {
    Optional<Claim> findByUuid(UUID uuid);
}
