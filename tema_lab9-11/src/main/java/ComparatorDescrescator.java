import java.util.Comparator;

public class ComparatorDescrescator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return b.compareTo(a);
    }
}