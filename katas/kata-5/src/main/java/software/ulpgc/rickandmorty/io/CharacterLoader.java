package software.ulpgc.rickandmorty.io;

import software.ulpgc.rickandmorty.model.Character;

public class CharacterLoader {
    private final CharacterReader reader;
    private final CharacterDeserializer deserializer;
    private final CharacterAdapter adapter;

    public CharacterLoader(CharacterReader reader, CharacterDeserializer deserializer, CharacterAdapter adapter) {
        this.reader = reader;
        this.deserializer = deserializer;
        this.adapter = adapter;
    }

    public Character get() {return adapter.adapt(deserializer.deserializer(reader.read()));}
}
