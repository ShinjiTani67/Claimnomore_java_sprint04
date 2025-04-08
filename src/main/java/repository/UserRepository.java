package repository;

import entity.Claim;
import entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<Claim> findByUuid(UUID uuid);

}
