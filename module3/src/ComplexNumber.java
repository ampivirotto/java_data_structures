public class ComplexNumber {
    private double a;
    private double b;

    public ComplexNumber(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public ComplexNumber add(ComplexNumber other){
        double newReal = this.a + other.a;
        double newComplex = this.b + other.b;
        return new ComplexNumber(newReal, newComplex);
    }

    public ComplexNumber subtract(ComplexNumber other){
        double newReal = this.a - other.a;
        double newComplex = this.b - other.b;

        return new ComplexNumber(newReal, newComplex);
    }

    public ComplexNumber multiply(ComplexNumber other){
        double newReal = (this.a * other.a) - (this.b * other.b);
        double newComplex = (this.a * other.b) + (this.b * other.a);

        return new ComplexNumber(newReal, newComplex);
    }

    public ComplexNumber divide(ComplexNumber other){
        double newReal = ((this.a * other.a) + (this.b * other.b)) / (Math.pow(other.a, 2) + Math.pow(other.b, 2));
        double newComplex = ((this.b * other.a) - (this.a * other.b)) / (Math.pow(other.a, 2) + Math.pow(other.b, 2));

        return new ComplexNumber(newReal, newComplex);
    }

    public String printString(){
        return this.a + " + " + this.b;
    }
}
