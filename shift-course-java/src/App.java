import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static boolean isInteger(String string) {
        return string.matches("-?\\d+");
    }

    public static boolean isFloat(String string) {
        return string.matches("-?\\d+\\.\\d+");
    }

    public static String checkType(String string) {
        if (isInteger(string)){
            return "integer";
        }
        if (isFloat(string)){
            return "float";
        }
        return "string";
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error: no files have been given");
            return;
        }

        for (String filePath : args) {
            File file = new File(filePath);
            if (file.exists() && file.isFile()) {
                try {
                    List<String> lines = Files.readAllLines(Paths.get(filePath));
                    System.out.println(filePath);
                    for (String line : lines) {
                        String res = checkType(line);
                        System.out.println(line + " " + res);
                    }
                } catch (IOException e) {
                    System.out.println("Couldn't read file " + filePath);
                    e.printStackTrace();
                }
            } else {
                System.out.println("FIle not found " + filePath);
            }
        }
    }
}
