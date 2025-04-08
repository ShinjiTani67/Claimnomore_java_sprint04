package repository;

import entity.Claim;

import java.util.List;

public interface DentistRepository extends MongoRepository<Long, id >{
    List<Claim> findByNome(long id);
}
