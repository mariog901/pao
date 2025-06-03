public interface Container {
    void add(Task task);
    Task remove();
    boolean isEmpty();
    int size();
}