package salt.se.puppiesapi.puppy;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaPuppyRepository extends CrudRepository<Puppy, Long> {
    @Override
    List<Puppy> findAll();
}
