import java.io.File;

import Statistics.Statistics;

public class Options {
    public String path;
    public String prefix;
    public boolean addToFile;
    public Statistics statistics;

    public Options(String newPath) {
        path = newPath;
        prefix = "";
        addToFile = false;
        statistics = Statistics.NONE;
    }

    public String createFileName(String name) {
        return path + File.separator + prefix + name;
    }
}
