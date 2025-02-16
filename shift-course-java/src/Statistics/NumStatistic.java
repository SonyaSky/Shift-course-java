package Statistics;
public class NumStatistic extends Statistic{
    private double sum;
    private double average;

    public NumStatistic() {
        super();
        sum = 0;
        average = 0;
    }

    public void addElement(Number element) {
        double value = element.doubleValue();
        super.addElement(value);
        sum += value;
        average = sum/quantity;
    }

    public void showFullStatistic(String file) {
        super.showShortStatistic(file);
        System.out.println("Sum of the elements: " + sum);
        System.out.println("Average value: " + average);
        System.out.println("The biggest number: " + maxElement);
        System.out.println("The smallest number: " + minElement);
    }
}
