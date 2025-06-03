public class CounterOutTask implements Task {
    private static int globalCounter = 0;

    @Override
    public void execute() {
        globalCounter++;
        System.out.println("Contorul global: " + globalCounter);
    }
    public static void resetCounter() {
        globalCounter = 0;
    }
}