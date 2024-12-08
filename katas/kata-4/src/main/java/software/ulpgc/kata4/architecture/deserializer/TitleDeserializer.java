package software.ulpgc.kata4.architecture.deserializer;


import software.ulpgc.kata4.architecture.Title;

public interface TitleDeserializer {
    Title deserialize(String line);
}
