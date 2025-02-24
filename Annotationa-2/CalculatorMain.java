import java.lang.reflect.Method;
class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}
public class CalculatorMain {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        multiplyMethod.setAccessible(true);
        int result = (int) multiplyMethod.invoke(calculator, 5, 4);
        System.out.println("Multiplication result: " + result);
    }
}
