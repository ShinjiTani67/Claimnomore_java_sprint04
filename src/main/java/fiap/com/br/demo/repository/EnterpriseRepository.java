package fiap.com.br.demo.repository;

import fiap.com.br.demo.entity.Enterprise;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface EnterpriseRepository extends MongoRepository<Enterprise, UUID> {
}