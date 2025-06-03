import java.util.Collection;
import java.util.LinkedList;

public class CountingLinkedList<E> extends LinkedList<E> {
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
        System.out.println("Dimensiunea listei: " + this.size());
        System.out.println("Total elemente adaugate: " + totalElementeAdaugate);
        System.out.println("Diferenta: " + (totalElementeAdaugate - this.size()));
    }
}
