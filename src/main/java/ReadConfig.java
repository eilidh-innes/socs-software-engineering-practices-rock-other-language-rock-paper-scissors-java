import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadConfig {

    public static List<String> getConfiguration(){
        final String configPath = "src/main/resources/rock.cfg";
        List<String> configurationData = new ArrayList<String>();
        try {
            File propertyFile = new File(configPath);
            Scanner propertyReader = new Scanner(propertyFile);
            while (propertyReader.hasNextLine()) {
                configurationData.add(propertyReader.nextLine());
            }
            propertyReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred " + e.getMessage());
            e.printStackTrace();
        }
        return configurationData;
    }
}
