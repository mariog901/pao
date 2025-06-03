public class Queue implements Container {
    private Task[] tasks;
    private int front;
    private int rear;
    private int currentSize;
    private static final int DEFAULT_CAPACITY = 10;

    public Queue() {
        this.tasks = new Task[DEFAULT_CAPACITY];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    @Override
    public void add(Task task) {
        if (currentSize == tasks.length) {
            resize();
        }
        rear = (rear + 1) % tasks.length;
        tasks[rear] = task;
        currentSize++;
    }

    @Override
    public Task remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        Task task = tasks[front];
        tasks[front] = null;
        front = (front + 1) % tasks.length;
        currentSize--;
        return task;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public int size() {
        return currentSize;
    }

    private void resize() {
        Task[] newTasks = new Task[tasks.length * 2];
        for (int i = 0; i < currentSize; i++) {
            newTasks[i] = tasks[(front + i) % tasks.length];
        }
        tasks = newTasks;
        front = 0;
        rear = currentSize - 1;
    }
}