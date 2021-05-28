package selenium.test.automation.utils.files;

import java.io.File;

public class FileHelper {

    public String getResourceFilePath(String resourcePath) {
        try {
            return new File(getClass().getClassLoader().getResource(resourcePath).getFile()).getAbsolutePath();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}