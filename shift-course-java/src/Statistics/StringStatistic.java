package Statistics;
public class StringStatistic extends Statistic {

    public StringStatistic() {
        super();
    }

    public void addString(String element) {
        super.addElement((double) element.length());
    }

    public void showFullStatistic(String file) {
        super.showShortStatistic(file);
        System.out.println("Length of the longest string: " + maxElement);
        System.out.println("Length of the shortest string: " + minElement);
    }
}
