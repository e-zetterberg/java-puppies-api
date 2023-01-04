package salt.se.puppiesapi.puppy;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuppyService {
    PuppyRepository repository;

    public PuppyService(PuppyRepository repository) {
        this.repository = repository;
    }

    public Puppy getPuppy(long id) {
        return repository.getPuppyById(id);
    }

    public Puppy createPuppy(Puppy newPuppy) {
        return repository.createPuppy(newPuppy);
    }

    public List<Puppy> getAllPuppies() {
        return repository.getAllPuppies();
    }

    public Puppy updatePuppy(long id, Puppy newPuppy) {
        Puppy updatedPuppy = new Puppy(id, newPuppy);
        return repository.updatePuppy(updatedPuppy);
    }
    public void deletePuppy(long id) {
        repository.deletePuppyById(id);
    }
}
