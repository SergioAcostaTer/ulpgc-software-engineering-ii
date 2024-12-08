package software.ulpgc.rickandmorty.io;

import software.ulpgc.rickandmorty.model.Character;

public interface CharacterAdapter {
    Character adapt(Object response);
}
