package software.ulpgc.kata4.architecture.io;


import software.ulpgc.kata4.architecture.Title;

import java.io.IOException;
import java.util.List;

public interface TitleLoader {
    List<Title> load() throws IOException;
}
