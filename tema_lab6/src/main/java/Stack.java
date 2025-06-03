public class Stack implements Container {
    private Task[] tasks;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    public Stack() {
        this.tasks = new Task[DEFAULT_CAPACITY];
        this.top = -1;
    }

    @Override
    public void add(Task task) {
        if (top == tasks.length - 1) {
            resize();
        }
        tasks[++top] = task;
    }

    @Override
    public Task remove() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        Task task = tasks[top];
        tasks[top--] = null;
        return task;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }

    private void resize() {
        Task[] newTasks = new Task[tasks.length * 2];
        System.arraycopy(tasks, 0, newTasks, 0, tasks.length);
        tasks = newTasks;
    }
}