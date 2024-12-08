package software.ulpgc.rickandmorty;

import software.ulpgc.rickandmorty.io.CharacterApiAdapter;
import software.ulpgc.rickandmorty.io.CharacterApiReader;
import software.ulpgc.rickandmorty.io.CharacterJsonDeserializer;
import software.ulpgc.rickandmorty.io.CharacterLoader;

public class Main {
    public static void main(String[] args) {
        CharacterLoader loader = new CharacterLoader(
                new CharacterApiReader(),
                new CharacterJsonDeserializer(),
                new CharacterApiAdapter()
        );


        for (int i = 0; i < 10; i++){
            System.out.println(loader.get());
        }

    }
}
