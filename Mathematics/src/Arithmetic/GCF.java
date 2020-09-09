package Arithmetic;

import java.util.*;

public class GCF {

    int gcf(int a, int b) {
        int n = Math.min(a, b);
        for (int i = n; i > 0; i--) {
            if (a % i == 0 && b % i == 0)
                return i;
        }
        return 1;
    }

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two numbers");
        int a = in.nextInt();
        int b = in.nextInt();
        GCF obj = new GCF();
        System.out.println(obj.gcf(a, b));
    }*/

}
