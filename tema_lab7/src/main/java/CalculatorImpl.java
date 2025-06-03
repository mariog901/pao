import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CalculatorImpl implements Calculator {
    @Override
    public double add(Double a, Double b) throws NullParameterException,
            OverflowException,
            UnderFlowException {
        if (a == null || b == null) {
            throw new NullParameterException(
                    "Parametrii nu pot fi null: a=" + a + ", b=" + b
            );
        }
        double result = a + b;
        if (result == Double.POSITIVE_INFINITY) {
            throw new OverflowException(
                    "Overflow: suma " + a + " + " + b + " = " + result
            );
        }
        if (result == Double.NEGATIVE_INFINITY) {
            throw new UnderFlowException(
                    "UnderFlow: suma " + a + " + " + b + " = " + result
            );
        }
        return result;
    }

    @Override
    public double divide(Double a, Double b) throws NullParameterException,
            MyArithmeticException,
            OverflowException,
            UnderFlowException {
        if (a == null || b == null) {
            throw new NullParameterException(
                    "Parametrii nu pot fi null: a=" + a + ", b=" + b
            );
        }

        if (b == 0.0) {
            throw new MyArithmeticException(
                    "Impartirea la zero nu este permisa"
            );
        }

        double result = a / b;

        if (result == Double.POSITIVE_INFINITY) {
            throw new OverflowException(
                    "Overflow: " + a + " / " + b + " = " + result
            );
        }

        if (result == Double.NEGATIVE_INFINITY) {
            throw new UnderFlowException(
                    "Underflow: " + a + " / " + b + " = " + result
            );
        }

        return result;
    }

    @Override
    public double average(Double[] numbers) throws NullParameterException,
            OverflowException,
            UnderFlowException,
            MyArithmeticException {
        if (numbers == null) {
            throw new NullParameterException("Array-ul nu poate fi null");
        }

        if (numbers.length == 0) {
            throw new MyArithmeticException("Array-ul nu poate fi gol");
        }

        // Verificăm dacă există elemente null
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == null) {
                throw new NullParameterException(
                        "Elementul de la index " + i + " este null"
                );
            }
        }
        double sum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            sum = add(sum, numbers[i]);
        }

        return divide(sum, (double) numbers.length);
    }

    public Double[] readNumbersFromFile(String filename) throws FileReadException {
        List<Double> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    try {
                        double number = Double.parseDouble(line);
                        numbers.add(number);
                    } catch (NumberFormatException e) {
                        throw new FileReadException(
                                "Valoare invalidă în fișier: " + line, e
                        );
                    }
                }
            }
        } catch (IOException e) {
            throw new FileReadException(
                    "Eroare la citirea fișierului: " + filename, e
            );
        }

        return numbers.toArray(new Double[0]);
    }
}