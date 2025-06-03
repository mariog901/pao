public class TestMain {
    public static void main(String[] args) {
        System.out.println(" TESTAREA TASK-URILOR \n");


        System.out.println("1. Test OutTask:");
        Task outTask1 = new OutTask("Salut din OutTask!");
        Task outTask2 = new OutTask("Al doilea mesaj");
        outTask1.execute();
        outTask2.execute();


        System.out.println("\n2. Test RandomOutTask:");
        Task randomTask1 = new RandomOutTask();
        Task randomTask2 = new RandomOutTask();
        Task randomTask3 = new RandomOutTask();
        randomTask1.execute();
        randomTask2.execute();
        randomTask3.execute();


        System.out.println("\n3. Test CounterOutTask:");
        Task counterTask1 = new CounterOutTask();
        Task counterTask2 = new CounterOutTask();
        Task counterTask3 = new CounterOutTask();
        counterTask1.execute();
        counterTask2.execute();
        counterTask3.execute();


        CounterOutTask.resetCounter();

        System.out.println("\n=== TESTAREA CONTAINERELOR ===\n");


        System.out.println("4. Test Stack (LIFO):");
        Stack stack = new Stack();

        stack.add(new OutTask("Primul în stack"));
        stack.add(new OutTask("Al doilea în stack"));
        stack.add(new OutTask("Al treilea în stack"));
        stack.add(new CounterOutTask());
        stack.add(new RandomOutTask());

        System.out.println("Dimensiunea stack-ului: " + stack.size());
        System.out.println("Extragere din stack (LIFO):");

        while (!stack.isEmpty()) {
            Task task = stack.remove();
            task.execute();
        }

        System.out.println("\n5. Test Queue (FIFO):");
        Queue queue = new Queue();

        queue.add(new OutTask("Primul în queue"));
        queue.add(new OutTask("Al doilea în queue"));
        queue.add(new OutTask("Al treilea în queue"));
        queue.add(new CounterOutTask());
        queue.add(new RandomOutTask());

        System.out.println("Dimensiunea queue-ului: " + queue.size());
        System.out.println("Extragere din queue (FIFO):");

        while (!queue.isEmpty()) {
            Task task = queue.remove();
            task.execute();
        }


        System.out.println("\n6. Test scenario mixt:");
        Stack mixedStack = new Stack();


        for (int i = 1; i <= 3; i++) {
            mixedStack.add(new OutTask("Task " + i));
            mixedStack.add(new RandomOutTask());
            mixedStack.add(new CounterOutTask());
        }

        System.out.println("Executarea task-urilor mixte din stack:");
        while (!mixedStack.isEmpty()) {
            mixedStack.remove().execute();
        }
    }
}
