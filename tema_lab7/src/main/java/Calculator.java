public interface Calculator {
    double add(Double a, Double b) throws NullParameterException,
            OverflowException,
            UnderFlowException;

    double divide(Double a, Double b) throws NullParameterException,
            MyArithmeticException,
            OverflowException,
            UnderFlowException;

    double average(Double[] numbers) throws NullParameterException,
            OverflowException,
            UnderFlowException,
            MyArithmeticException;
}