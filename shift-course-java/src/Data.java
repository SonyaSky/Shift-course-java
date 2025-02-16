import java.util.ArrayList;

import Statistics.NumStatistic;
import Statistics.StringStatistic;

public class Data {
    private ArrayList<String> integers;
    private ArrayList<String> floats;
    private ArrayList<String> strings;
    private NumStatistic intStatistic;
    private NumStatistic floatStatistic;
    private StringStatistic stringStatistic;

    public Data() {
        integers = new ArrayList<>();
        floats = new ArrayList<>();
        strings = new ArrayList<>();
        intStatistic = new NumStatistic();
        floatStatistic = new NumStatistic();
        stringStatistic = new StringStatistic();
    }

    public void addElement(String element, String type) {
        switch (type) {
            case "integer":
                integers.add(element);
                intStatistic.addElement(Long.parseLong(element));
                break;
            case "float":
                floats.add(element);
                floatStatistic.addElement(Double.parseDouble(element));
                break;
            case "string":
                strings.add(element);
                stringStatistic.addString(element);
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

    public void showStatistic(String type) {
        switch (type) {
            case "short":
                if (!integers.isEmpty()) {
                    intStatistic.showShortStatistic("Integers:");
                }
                if (!floats.isEmpty()) {
                    floatStatistic.showShortStatistic("Floats:");
                }
                if (!strings.isEmpty()) {
                    stringStatistic.showShortStatistic("Strings:");
                }
                break;
            case "full":
                if (!integers.isEmpty()) {
                    intStatistic.showFullStatistic("Integers:");
                }
                if (!floats.isEmpty()) {
                    floatStatistic.showFullStatistic("Floats:");
                }
                if (!strings.isEmpty()) {
                    stringStatistic.showFullStatistic("Strings:");
                }
                break;
            default:
                break;
        }
    }

}
