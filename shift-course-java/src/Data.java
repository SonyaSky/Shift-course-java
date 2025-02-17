import java.util.ArrayList;

import Statistics.NumStatistic;
import Statistics.StringStatistic;

public class Data {
    private NumStatistic intStatistic;
    private NumStatistic floatStatistic;
    private StringStatistic stringStatistic;

    public Data() {
        intStatistic = new NumStatistic();
        floatStatistic = new NumStatistic();
        stringStatistic = new StringStatistic();
    }

    public void addElement(String element, String type) {
        switch (type) {
            case "integer":
                intStatistic.addElement(element, type);
                break;
            case "float":
                floatStatistic.addElement(element, type);
                break;
            case "string":
                stringStatistic.addString(element);
                break;
            default:
                break;
        }
    }

    public ArrayList<String> getIntegers() {
        return intStatistic.getData();
    }

    public ArrayList<String> getFloats() {
        return floatStatistic.getData();
    }

    public ArrayList<String> getStrings() {
        return intStatistic.getData();
    }

    public void displayLists() {
        System.out.println("Integer List: " + getIntegers());
        System.out.println("Float List: " + getFloats());
        System.out.println("String List: " + getStrings());
    }

    public void showStatistic(String type) {
        switch (type) {
            case "short":
                if (!getIntegers().isEmpty()) {
                    intStatistic.showShortStatistic("Integers:");
                    System.out.println();
                }
                if (!getFloats().isEmpty()) {
                    floatStatistic.showShortStatistic("Floats:");
                    System.out.println();
                }
                if (!getStrings().isEmpty()) {
                    stringStatistic.showShortStatistic("Strings:");
                }
                break;
            case "full":
                if (!getIntegers().isEmpty()) {
                    intStatistic.showFullStatistic("Integers:", true);
                    System.out.println();
                }
                if (!getFloats().isEmpty()) {
                    floatStatistic.showFullStatistic("Floats:", false);
                    System.out.println();
                }
                if (!getStrings().isEmpty()) {
                    stringStatistic.showFullStatistic("Strings:");
                }
                break;
            default:
                break;
        }
    }

}
