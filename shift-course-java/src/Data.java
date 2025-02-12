import java.util.ArrayList;

public class Data {
    private ArrayList<String> integers;
    private ArrayList<String> floats;
    private ArrayList<String> strings;

    public Data() {
        integers = new ArrayList<>();
        floats = new ArrayList<>();
        strings = new ArrayList<>();
    }

    public void addElement(String element, String type) {
        switch (type) {
            case "integer":
                integers.add(element);
                break;
            case "float":
                floats.add(element);
                break;
            case "string":
                strings.add(element);
                break;
            default:
                break;
        }
    }

    public ArrayList<String> getIntegers() {
        return integers;
    }

    public ArrayList<String> getFloats() {
        return integers;
    }

    public ArrayList<String> getStrings() {
        return integers;
    }

    public void displayLists() {
        System.out.println("Integer List: " + integers);
        System.out.println("Float List: " + floats);
        System.out.println("String List: " + strings);
    }
}
