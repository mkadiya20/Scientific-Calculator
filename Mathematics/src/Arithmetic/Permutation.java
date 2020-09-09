package Arithmetic;

import Arithmetic.Factorial;

public class Permutation {
    int n, r;

    public Permutation(int n, int r) {
        this.n = n;
        this.r = r;
    }

    int calculate() {
        Factorial f = new Factorial();
        int ans = f.factorial(n);
        ans = ans / f.factorial(n - r);
        return ans;
    }

    void show() {
        System.out.println(n + "P" + r);
    }
}
