package software.ulpgc.rickandmorty.model;

import software.ulpgc.rickandmorty.contracts.CharacterGetResponse;

public class Character {
    private int id;
    private final String name;
    private final String status;
    private final String species;
    private final String gender;
    private final String origin;
    private final String location;
    private final String image;

    public Character(CharacterGetResponse.Location location, String image, CharacterGetResponse.Origin origin, String gender, String species, String status, String name, int id) {
        this.location = String.valueOf(location);
        this.image = image;
        this.origin = String.valueOf(origin);
        this.gender = gender;
        this.species = species;
        this.status = status;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", species='" + species + '\'' +
                ", gender='" + gender + '\'' +
                ", origin='" + origin + '\'' +
                ", location='" + location + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public String getOrigin() {
        return origin;
    }

    public String getLocation() {
        return location;
    }

    public String getImage() {
        return image;
    }
}
