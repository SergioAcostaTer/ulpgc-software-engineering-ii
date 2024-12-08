package software.ulpgc.kata4.architecture.io;

import software.ulpgc.kata4.architecture.Title;

import java.util.List;

public interface TitleRepository {
    List<Title> load();
}
