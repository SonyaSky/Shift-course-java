package Statistics;
public class StringStatistic extends Statistic {

    public StringStatistic() {
        super();
    }

    public void addString(String element) {
        super.addElement(element);
        if (element.length() > data.get(maxElement).length()) {
            maxElement = quantity - 1;
        }
        if (element.length() < data.get(minElement).length()) {
            minElement = quantity - 1;
        }
    }

    public void showFullStatistic(String file) {
        super.showShortStatistic(file);
        System.out.println("Length of the longest string: " + maxElement);
        System.out.println("Length of the shortest string: " + minElement);
    }
}
