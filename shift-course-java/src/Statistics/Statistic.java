package Statistics;
public class Statistic {
    protected double minElement;
    protected double maxElement;
    protected int quantity;

    public Statistic() {
        quantity = 0;
    }

    public void showShortStatistic(String file) {
        System.out.println(file);
        System.out.println("Number of elements: " + quantity);
    }

    public void addElement(double element) {
        if (quantity == 0) {
            maxElement = element;
            minElement = element;
        }
        else if (element < minElement) {
            minElement = element;
        }
        else if (element > maxElement) {
            maxElement = element;
        }
        quantity++;
    }

}
