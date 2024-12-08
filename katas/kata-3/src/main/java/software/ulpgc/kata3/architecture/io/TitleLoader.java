package software.ulpgc.kata3.architecture.io;


import software.ulpgc.kata3.architecture.Title;

import java.io.IOException;
import java.util.List;

public interface TitleLoader {
    List<Title> load() throws IOException;
}
