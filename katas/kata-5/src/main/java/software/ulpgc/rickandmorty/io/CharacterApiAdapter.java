package software.ulpgc.rickandmorty.io;

import software.ulpgc.rickandmorty.contracts.CharacterGetResponse;
import software.ulpgc.rickandmorty.model.Character;

public class CharacterApiAdapter implements CharacterAdapter{
    @Override
    public software.ulpgc.rickandmorty.model.Character adapt(Object response) {
        return adapt((CharacterGetResponse.CharacterData) response);
    }


    private software.ulpgc.rickandmorty.model.Character adapt(CharacterGetResponse.CharacterData response){
        return new Character(
                response.location(),
                response.image(),
                response.origin(),
                response.gender(),
                response.species(),
                response.status(),
                response.name(),
                response.id()
        );
    }
}
