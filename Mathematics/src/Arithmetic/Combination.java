package Arithmetic;

public class Combination {
    int n, r;

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
    }

    int calculate() {
        Factorial f = new Factorial();
        int ans = f.factorial(n);
        ans = ans / f.factorial(n - r);
        ans = ans / f.factorial(r);
        return ans;
    }

    void show() {
        System.out.println(n + "C" + r);
    }
}
