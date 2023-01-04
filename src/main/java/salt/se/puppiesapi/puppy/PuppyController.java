package salt.se.puppiesapi.puppy;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/puppies")
public class PuppyController {

    PuppyService service;

    public PuppyController(PuppyService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<Puppy>> getAllPuppies(){
        List<Puppy> puppyList = service.getAllPuppies();
        return ResponseEntity.ok(puppyList);
    }

    @GetMapping("/{puppyId}")
    ResponseEntity<Puppy> getPuppy(@PathVariable long puppyId){
        try {
            Puppy puppy = service.getPuppy(puppyId);
            return ResponseEntity.ok(puppy);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    ResponseEntity<Puppy> createPuppy(@RequestBody PuppyDto newPuppydto){
        try {
            Puppy createdPuppy = service.createPuppy(new Puppy(newPuppydto));
            URI location = URI.create("/api/puppies/" + createdPuppy.puppyId);
            return ResponseEntity.created(location).body(createdPuppy);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (UnsupportedOperationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{puppyId}")
    ResponseEntity<Puppy> updatePuppy(@PathVariable long puppyId, @RequestBody PuppyDto puppydto){
        try {
            Puppy updatedPuppy = service.updatePuppy(puppyId, new Puppy(puppydto));
            return ResponseEntity.accepted().body(updatedPuppy);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{puppyId}")
    ResponseEntity<Void> deletePuppy(@PathVariable long puppyId){
        try {
            service.deletePuppy(puppyId);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.noContent().build();
    }



}
