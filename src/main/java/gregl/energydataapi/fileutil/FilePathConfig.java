package gregl.energydataapi.fileutil;

import lombok.Getter;

@Getter
public class FilePathConfig {
    private static FilePathConfig instance;
    private final String basePath = "src/main/resources/static/";

    private FilePathConfig() {}

    public static FilePathConfig getInstance() {
        if (instance == null) {
            instance = new FilePathConfig();
        }
        return instance;
    }

}
