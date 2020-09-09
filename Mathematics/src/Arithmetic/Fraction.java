package Arithmetic;

import java.util.*;

public class Fraction {

    public int num, denom;

    public Fraction(int n, int d) throws Exception {
        if (d == 0)
            throw new Exception("Fraction not defined");
        num = n;
        denom = d;
    }

    public void simplify() {
        GCF obj = new GCF();
        int factor = obj.gcf(Math.abs(num), Math.abs(denom));
        if (num < 0 && denom < 0) {
            num = (num / factor) * -1;
            denom = (denom / factor) * -1;
        } else {
            num = num / factor;
            denom = denom / factor;
        }
    }

    Fraction plus(Fraction frac) throws Exception {
        Fraction f = new Fraction(0, 0);
        f.num = num * frac.denom + denom * frac.num;
        f.denom = denom * frac.denom;
        f.simplify();
        return f;
    }

    Fraction minus(Fraction frac) throws Exception {
        Fraction f = new Fraction(0, 0);
        f.num = num * frac.denom - denom * frac.num;
        f.denom = denom * frac.denom;
        simplify();
        return f;
    }

    Fraction multiply(Fraction frac) throws Exception {
        Fraction f = new Fraction(0, 0);
        f.num = num * frac.num;
        f.denom = denom * frac.denom;
        simplify();
        return f;
    }

    Fraction divide(Fraction frac) throws Exception {
        Fraction f = new Fraction(0, 0);
        f.num = num * frac.denom;
        f.denom = denom * frac.num;
        simplify();
        return f;
    }

    static Fraction toFraction(double n) throws Exception {
        String num = Double.toString(n);
        int ind = num.indexOf('.');
        int decimals = num.substring(ind).length();
        int numerator = (int) (n * Math.pow(10, decimals));
        int denominator = (int) (Math.pow(10, decimals));
        Fraction f = new Fraction(numerator, denominator);
        f.simplify();
        return f;
    }

    public void show() {
        System.out.println(num + " / " + denom);
    }

    /*public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter any decimal");
        double n = in.nextDouble();
        Fraction f = toFraction(n);
        f.show();
    }*/
}
