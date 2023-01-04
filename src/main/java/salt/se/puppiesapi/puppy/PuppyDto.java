package salt.se.puppiesapi.puppy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PuppyDto(
        long id,
        String name,
        String breed,
        String birthDate
) {
}
