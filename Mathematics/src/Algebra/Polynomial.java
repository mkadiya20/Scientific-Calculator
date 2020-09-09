package Algebra;

public class Polynomial {
    int coef[], degree;

    public Polynomial(int[] coef) {
        this.coef = coef;
        reduce();
    }

    private void reduce() {
        degree = -1;
        for (int i = coef.length - 1; i >= 0; i--) {
            if (coef[i] != 0) {
                degree = i;
                return;
            }
        }
    }

    Polynomial add(Polynomial poly) {
        int[] temp = new int[Math.max(degree, poly.degree)];
        Polynomial p = new Polynomial(temp);
        for (int i = 0; i <= poly.coef.length; i++)
            p.coef[i] += poly.coef[i];
        for (int i = 0; i <= coef.length; i++)
            p.coef[i] += coef[i];

        p.reduce();
        return p;
    }

    Polynomial subtract(Polynomial poly) {
        int[] temp = new int[Math.max(degree, poly.degree)];
        Polynomial p = new Polynomial(temp);
        for (int i = 0; i <= coef.length; i++)
            p.coef[i] += coef[i];
        for (int i = 0; i <= poly.coef.length; i++)
            p.coef[i] -= poly.coef[i];

        p.reduce();
        return p;
    }

    Polynomial multiply(Polynomial poly) {
        int[] temp = new int[degree + poly.degree + 1];
        Polynomial p = new Polynomial(temp);
        for (int i = 0; i < coef.length; i++) {
            for (int j = 0; j < poly.coef.length; j++) {
                p.coef[i + j] += (coef[i] * poly.coef[j]);
            }
        }

        p.reduce();
        return p;
    }

    void show() {
        for (int i = coef.length - 1; i > 0; i--) {
        System.out.print(coef[i] + "x^" + i + "+");
    }
        System.out.println(coef[0]);
}
}
