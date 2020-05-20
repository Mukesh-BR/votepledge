package ca.votepledge.repositories;

import ca.votepledge.model.Pledge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotersRepository extends MongoRepository<Pledge,String> {
}
