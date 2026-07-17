package javaprac2_b;

import javax.swing.JOptionPane;

interface Arithmetic {

    int sum(int a, int b);

    int difference(int a, int b);

    int product(int a, int b);

    double quotient(int a, int b);
}

class MyCalculator implements Arithmetic {

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int difference(int a, int b) {
        return a - b;
    }

    @Override
    public int product(int a, int b) {
        return a * b;
    }

    @Override
    public double quotient(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return (double) a / b;
    }
}

public class JavaPrac2_B {

    public static void main(String[] args) {

        Arithmetic calc = new MyCalculator();

        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Enter First Number"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Enter Second Number"));

        String result = "";

        result += "Sum = " + calc.sum(num1, num2) + "\n";
        result += "Difference = " + calc.difference(num1, num2) + "\n";
        result += "Product = " + calc.product(num1, num2) + "\n";

        if (num2 == 0) {
            result += "Quotient = Cannot divide by zero";
        } else {
            result += "Quotient = " + calc.quotient(num1, num2);
        }

        JOptionPane.showMessageDialog(null, result, "Calculator", JOptionPane.INFORMATION_MESSAGE);
    }
}