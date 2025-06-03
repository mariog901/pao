import java.io.FileWriter;
import java.io.IOException;

public class CalculatorTest {
    public static void main(String[] args) {
        CalculatorImpl calculator = new CalculatorImpl();

        createTestFile();

        System.out.println("TESTAREA CALCULATORULUI \n");
        
        System.out.println("1. Test NullParameterException:");
        testNullParameter(calculator);


        System.out.println("\n2. Test MyArithmeticException (împartire la zero):");
        testDivisionByZero(calculator);


        System.out.println("\n3. Test OverflowException:");
        testOverflow(calculator);


        System.out.println("\n4. Test UnderflowException:");
        testUnderflow(calculator);


        System.out.println("\n5. Test operatii normale:");
        testNormalOperations(calculator);


        System.out.println("\n6. Test citire din fisier si media:");
        testFileReading(calculator);


        System.out.println("\n7. Test array gol pentru medie:");
        testEmptyArray(calculator);
    }

    private static void createTestFile() {
        try (FileWriter writer = new FileWriter("numbers.txt")) {
            writer.write("10.5\n");
            writer.write("20.3\n");
            writer.write("15.7\n");
            writer.write("8.9\n");
            writer.write("12.1\n");
        } catch (IOException e) {
            System.err.println("Eroare la crearea fisierului de test: " + e.getMessage());
        }
    }

    private static void testNullParameter(CalculatorImpl calculator) {
        try {
            calculator.add(null, 5.0);
        } catch (NullParameterException e) {
            System.out.println(" NullParameterException prinsa: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" Exceptie neasteptata: " + e.getMessage());
        }

        try {
            calculator.average(null);
        } catch (NullParameterException e) {
            System.out.println(" NullParameterException prinsa pentru array null: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exceptie neasteptata " + e.getMessage());
        }
    }

    private static void testDivisionByZero(CalculatorImpl calculator) {
        try {
            calculator.divide(10.0, 0.0);
        } catch (MyArithmeticException e) {
            System.out.println("MyArithmeticException prinsa: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("exceptie neasteptata: " + e.getMessage());
        }
    }

    private static void testOverflow(CalculatorImpl calculator) {
        try {
            calculator.add(Double.MAX_VALUE, Double.MAX_VALUE);
        } catch (OverflowException e) {
            System.out.println("Overflow prinsa: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exceptie neasteptata : " + e.getMessage());
        }
    }

    private static void testUnderflow(CalculatorImpl calculator) {
        try {
            calculator.add(-Double.MAX_VALUE, -Double.MAX_VALUE);
        } catch (UnderFlowException e) {
            System.out.println("Underflow exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" exceptie neasteptata: " + e.getMessage());
        }
    }

    private static void testNormalOperations(CalculatorImpl calculator) {
        try {
            double sum = calculator.add(10.5, 20.3);
            System.out.println(" Adunare: 10.5 + 20.3 = " + sum);

            double division = calculator.divide(50.0, 2.0);
            System.out.println(" Impartire: 50.0 / 2.0 = " + division);

            Double[] numbers = {10.0, 20.0, 30.0};
            double avg = calculator.average(numbers);
            System.out.println(" Media pentru [10.0, 20.0, 30.0] = " + avg);

        } catch (Exception e) {
            System.out.println("Exceptie neasteptata in operatii normale: " + e.getMessage());
        }
    }

    private static void testFileReading(CalculatorImpl calculator) {
        try {
            Double[] numbers = calculator.readNumbersFromFile("numbers.txt");
            System.out.println(" Numere citite din fisier:");
            for (Double num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();

            double average = calculator.average(numbers);
            System.out.println(" Media numerelor din fisier: " + average);

        } catch (Exception e) {
            System.out.println(" Eroare la citirea din fisier: " + e.getMessage());
        }
    }

    private static void testEmptyArray(CalculatorImpl calculator) {
        try {
            Double[] emptyArray = {};
            calculator.average(emptyArray);
        } catch (MyArithmeticException e) {
            System.out.println(" MyArithmeticException prinsa pentru array gol: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" Excepție neasteptata: " + e.getMessage());
        }
    }
}