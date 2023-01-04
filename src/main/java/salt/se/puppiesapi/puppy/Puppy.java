package salt.se.puppiesapi.puppy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Puppy {

    @Id
    @Column(name = "puppy_id")
    long puppyId;

    private String name;

    private String breed;

    private String birthDate;

    public long getPuppyId() {
        return puppyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Puppy(){}
    public Puppy(long id, Puppy puppy) {
        this.puppyId = id;
        this.name = puppy.getName();
        this.breed = puppy.getBreed();
        this.birthDate = puppy.getBirthDate();
    }

    public Puppy(PuppyDto dto) {
        this.name = dto.name();
        this.breed = dto.breed();

    }

}
