package Algebra;

public class LinearEqn {

    Polynomial eqn;

    public LinearEqn(Polynomial p) {
        eqn = p;
    }

    void root() {
        int x = (-eqn.coef[0]) / (eqn.coef[1]);
        System.out.println("X = " + x);
    }
}
