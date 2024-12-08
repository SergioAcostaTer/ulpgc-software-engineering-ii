package software.ulpgc.rickandmorty.io;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class CharacterApiReader implements CharacterReader{
    private int currentId = 0;


    @Override
    public String read() {
        try {
            return fetchCharacterJson(currentId++);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String fetchCharacterJson(int id) throws IOException {
        String url = "https://rickandmortyapi.com/api/character/" + currentId;
        Connection.Response response = Jsoup.connect(url).ignoreContentType(true).header("accept", "application/json").method(org.jsoup.Connection.Method.GET).execute();

        if (response.statusCode() != 200){
            throw new RuntimeException("Failed");
        }

        return response.body();
    }
}
