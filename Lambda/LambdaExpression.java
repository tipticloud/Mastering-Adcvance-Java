package Lambda;

@FunctionalInterface
interface MyFunc {
    int operation(int a, int b);
}

public class LambdaExpression {
    public static void main(String[] args) {
        MyFunc add = (a, b) -> a + b;
        MyFunc multiply = (a, b) -> a * b;

        System.out.println("Sum: " + add.operation(10, 5));
        System.out.println("Product: " + multiply.operation(10, 5));
    }
}
