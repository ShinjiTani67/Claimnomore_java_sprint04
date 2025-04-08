package repository;

import entity.Claim;
import java.util.List;

public interface ClaimRepository extends MongoRepository<long, id > {

    List<Claim> findByNome(long id);
    
}
