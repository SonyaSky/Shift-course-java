import java.util.ArrayList;

import Statistics.NumStatistic;
import Statistics.Statistics;
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
                stringStatistic.addElement(element);
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
        return stringStatistic.getData();
    }

    public void displayLists() {
        System.out.println("Integer List: " + getIntegers());
        System.out.println("Float List: " + getFloats());
        System.out.println("String List: " + getStrings());
    }

    public void showStatistic(Statistics type) {
        switch (type) {
            case SHORT:
                intStatistic.showShortStatistic("Integers:");
                floatStatistic.showShortStatistic("Floats:");
                stringStatistic.showShortStatistic("Strings:");
                break;
            case FULL:
                intStatistic.showFullStatistic("Integers:", true);
                floatStatistic.showFullStatistic("Floats:", false);
                stringStatistic.showFullStatistic("Strings:");
                break;
            default:
                break;
        }
    }

}
