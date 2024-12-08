package software.ulpgc.rickandmorty.contracts;

import java.util.List;

public record CharacterGetResponse(List<CharacterData> result) {

    public record CharacterData(
            int id,
            String name,
            String status,
            String species,
            String gender,
            Origin origin,
            Location location,
            String image
    ){

    }

    public record Origin(String name){}
    public record Location(String name){}
}
