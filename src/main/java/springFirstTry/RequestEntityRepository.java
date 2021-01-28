package springFirstTry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestEntityRepository extends CrudRepository<RequestEntity, Long> {}



