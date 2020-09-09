package Algebra;

import Arithmetic.Fraction;

import java.util.*;

public class Determinant {
    private Cofactor factor = new Cofactor();

    public int det(int[][] arr, int n) {

        int sign = 1;
        int sum = 0;
        int[][] temp;

        if (n == 1)
            return arr[0][0];

        for (int i = 0; i < n; i++) {

            temp = factor.getCofactors(arr, 0, i);
            sum += sign * arr[0][i] * det(temp, n - 1);
            sign *= -1;

        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int arr[][] = new int[m][m];
        for(int i =0;i<m;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j] = in.nextInt();
            }
        }
        Determinant d = new Determinant();
        Matrix mat = new Matrix(arr);
        Fraction a[][] = mat.inverseMatrix(arr);
        Matrix m1 = new Matrix(a);
        m1.displayMatrix();
        System.out.println(d.det(arr,m));
    }
}
