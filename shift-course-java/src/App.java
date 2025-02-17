import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Statistics.Statistics;

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

    public static void writeFile(String path, ArrayList<String> data, boolean addToFile) {
        BufferedWriter writer = null;
        if (data.isEmpty()) return;

        File file = new File(path);

        if (!file.exists()) {
            System.out.println("File " + path + " was not found, so it will be created");
        }

        try {
            writer = new BufferedWriter(new FileWriter(path, addToFile));

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

        String currentDir = new File(".").getAbsolutePath();
        Options options = new Options(currentDir);
        ArrayList<String> inputFiles = new ArrayList<>();

        int i = 0;
        while (i < args.length) {
            switch (args[i]) {
                case "-o":
                    if (i+1 < args.length) {
                        options.path = args[i+1];
                        i++;
                    }
                    break;
                case "-p":
                    if (i+1 < args.length) {
                        options.prefix = args[i+1];
                        i++;
                    }
                    break;
                case "-a":
                    options.addToFile = true;
                    break;
                case "-s":
                    options.statistics = Statistics.SHORT;
                    break;
                case "-f":
                    options.statistics = Statistics.FULL;
                    break;
                default:
                    inputFiles.add(args[i]);
                    break;
            }
            i++;
        }

        for (String filePath : inputFiles) {
            File file = new File(filePath);
            if (file.exists() && file.isFile()) {
                try {
                    List<String> lines = Files.readAllLines(Paths.get(filePath));
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

        results.showStatistic(options.statistics);
        //results.displayLists();

        writeFile(options.createFileName("integers.txt"), results.getIntegers(), options.addToFile);
        writeFile(options.createFileName("floats.txt"), results.getFloats(), options.addToFile);
        writeFile(options.createFileName("strings.txt"), results.getStrings(), options.addToFile);

    }
}
