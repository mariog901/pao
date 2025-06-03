import java.util.Collection;
import java.util.HashSet;

public class CountingHashSet<E> extends HashSet<E> {
    private int totalElementeAdaugate = 0;

    @Override
    public boolean add(E element) {
        totalElementeAdaugate++;
        return super.add(element);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        totalElementeAdaugate += collection.size();
        return super.addAll(collection);
    }

    public int getTotalElementeAdaugate() {
        return totalElementeAdaugate;
    }

    public void resetCounter() {
        totalElementeAdaugate = 0;
    }

    public void afiseazaStatistici() {
        System.out.println("Dimensiunea setului: " + this.size());
        System.out.println("Total elemente adaugate: " + totalElementeAdaugate);
        System.out.println("Elemente duplicate respinse: " +
                (totalElementeAdaugate - this.size()));
    }
}