public class useCompNum {
    public static void main(String[] args) {
        ComplexNumber num1 = new ComplexNumber(59.5, 44.8);
        ComplexNumber num2 = new ComplexNumber(2.0, 1.5);

        ComplexNumber num4 = num1.add(num2);
        System.out.println(num4.printString());

        ComplexNumber num5 = num1.subtract(num2);
        System.out.println(num5.printString());

        ComplexNumber num6 = num1.multiply(num2);
        System.out.println(num6.printString());

        ComplexNumber num3 = num1.divide(num2);
        System.out.println(num3.printString());
    }
}
