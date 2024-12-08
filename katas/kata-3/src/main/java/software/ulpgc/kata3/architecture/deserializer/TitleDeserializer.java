package software.ulpgc.kata3.architecture.deserializer;


import software.ulpgc.kata3.architecture.Title;

public interface TitleDeserializer {
    Title deserialize(String line);
}
