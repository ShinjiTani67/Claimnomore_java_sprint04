package repository;

import entity.Claim;
import entity.Dentist;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import java.util.UUID;


public interface DentistRepository extends MongoRepository<Dentist, String> {
    Optional<Claim> findByUuid(UUID uuid);
}
