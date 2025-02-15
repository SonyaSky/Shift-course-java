import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static boolean isInteger(String string) {
        return string.matches("-?\\d+");
    }

    public static boolean isFloat(String string) {
        try {  
            Double.parseDouble(string);  
            return true;
          } catch(NumberFormatException e){  
            return false;  
          } 
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

    public static void writeFile(String path, String name, ArrayList<String> data) {
        BufferedWriter writer = null;
        if (data.isEmpty()) return;
        try {
            writer = new BufferedWriter(new FileWriter(path + File.separator + name));

            for (String line : data) {
                writer.write(line);
                writer.newLine(); 
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        } finally {
            try {
                if (writer != null) {
                    writer.close(); 
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error: no files have been given");
            return;
        }

        Data results = new Data();

        for (String filePath : args) {
            File file = new File(filePath);
            if (file.exists() && file.isFile()) {
                try {
                    List<String> lines = Files.readAllLines(Paths.get(filePath));
                    System.out.println(filePath);
                    for (String line : lines) {
                        String type = checkType(line);
                        results.addElement(line, type);
                    }
                } catch (IOException e) {
                    System.out.println("Couldn't read file " + filePath);
                    e.printStackTrace();
                }
            } else {
                System.out.println("File not found " + filePath);
            }
        }

        results.displayLists();

        String currentDir = new File(".").getAbsolutePath();
        writeFile(currentDir, "integers.txt", results.getIntegers());
        writeFile(currentDir, "floats.txt", results.getFloats());
        writeFile(currentDir, "strings.txt", results.getStrings());

    }
}
