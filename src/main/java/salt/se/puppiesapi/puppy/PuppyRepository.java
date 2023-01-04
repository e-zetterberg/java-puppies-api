package salt.se.puppiesapi.puppy;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PuppyRepository{

    JpaPuppyRepository puppyRepository;
    public PuppyRepository(JpaPuppyRepository puppyRepository) {
        this.puppyRepository = puppyRepository;
    }

    public List<Puppy> getAllPuppies() {
        return puppyRepository.findAll();
    }

    public Puppy getPuppyById(long id) {
        return puppyRepository.findById(id).orElseThrow();
    }

    public void deletePuppyById(long id) {
        puppyRepository.deleteById(id);
    }

    public Puppy savePuppy(Puppy puppy){
        return puppyRepository.save(puppy);
    }
}
