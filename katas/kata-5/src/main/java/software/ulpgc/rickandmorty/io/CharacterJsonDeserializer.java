package software.ulpgc.rickandmorty.io;

import com.google.gson.Gson;
import software.ulpgc.rickandmorty.contracts.CharacterGetResponse;

public class CharacterJsonDeserializer implements CharacterDeserializer{
    @Override
    public Object deserializer(String json) {
        return new Gson().fromJson(json, CharacterGetResponse.CharacterData.class);
    }
}
