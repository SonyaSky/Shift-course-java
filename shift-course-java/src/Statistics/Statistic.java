package Statistics;

import java.util.ArrayList;

public class Statistic {
    protected ArrayList<String> data;
    protected int minElement;
    protected int maxElement;
    protected int quantity;

    public Statistic() {
        quantity = 0;
        data = new ArrayList<>();
    }

    public void showShortStatistic(String file) {
        if (data.isEmpty()) {
            return;
        }
        System.out.println();
        System.out.println(file);
        System.out.println("Number of elements: " + quantity);
    }

    public void addElement(String element) {
        if (quantity == 0) {
            maxElement = 0;
            minElement = 0;
        }
        quantity++;
        data.add(element);
    }

    public ArrayList<String> getData() {
        return data;
    }

}
