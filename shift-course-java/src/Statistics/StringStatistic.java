package Statistics;
public class StringStatistic extends Statistic {

    public StringStatistic() {
        super();
    }

    @Override
    public void addElement(String element) {
        super.addElement(element);
        if (quantity == 1) {
            minElement = 0;
            maxElement = 0;
        } else {
            if (element.length() > data.get(maxElement).length()) {
                maxElement = quantity - 1;
            }
            if (element.length() < data.get(minElement).length()) {
                minElement = quantity - 1;
            }
        }
    }

    public void showFullStatistic(String file) {
        if (data.isEmpty()) {
            return;
        }
        super.showShortStatistic(file);
        System.out.println("Length of the longest string: " + data.get(maxElement).length());
        System.out.println("Length of the shortest string: " + data.get(minElement).length());
    }
}
