package Statistics;
public class NumStatistic extends Statistic{
    private double floatSum;
    private long intSum;
    private double average;

    public NumStatistic() {
        super();
        floatSum = 0;
        intSum = 0;
        average = 0;
    }

    public void addElement(String element, String type) {
        super.addElement(element);
        switch (type) {
            case "integer":
                long value = Long.parseLong(element);
                intSum += value;
                average = intSum/quantity;
                if (value > Long.parseLong(data.get(maxElement))) {
                    maxElement = quantity - 1;
                }
                else if (value < Long.parseLong(data.get(minElement))) {
                    minElement = quantity - 1;
                }
                break;
            case "float":
                double floatValue = Double.parseDouble(element);
                floatSum += floatValue;
                average = floatSum/quantity;
                if (floatValue > Double.parseDouble(data.get(maxElement))) {
                    maxElement = quantity - 1;
                }
                else if (floatValue < Double.parseDouble(data.get(minElement))) {
                    minElement = quantity - 1;
                }
                break;
            default:
                break;
        }
    }

    public void showFullStatistic(String file, boolean isInt) {
        if (data.isEmpty()) {
            return;
        }
        super.showShortStatistic(file);
        if (isInt) {
            System.out.println("Sum of the elements: " + intSum);
        }
        else {
            System.out.println("Sum of the elements: " + floatSum);
        }
        System.out.println("Average value: " + average);
        System.out.println("The biggest number: " + data.get(maxElement));
        System.out.println("The smallest number: " + data.get(minElement));
    }
}
