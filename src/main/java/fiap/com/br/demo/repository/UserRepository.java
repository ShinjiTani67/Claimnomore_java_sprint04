package fiap.com.br.demo.repository;

import fiap.com.br.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {

    Optional<User> findByUuid(UUID uuid);

}
