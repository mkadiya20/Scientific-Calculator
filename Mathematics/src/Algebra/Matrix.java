package Algebra;

import Arithmetic.Fraction;

import java.util.*;

public class Matrix {
    private int[][] mat;
    private Fraction[][] f;

    public Matrix(int[][] arr) {
        mat = arr;
    }

    public Matrix(Fraction[][] arr) {
        f = arr;
    }


    int[][] addMatrix(int[][] arr) throws Exception {
        int l1 = arr.length;
        int l2 = arr[0].length;

        if (l1 != mat.length || l2 != mat[0].length)
            throw new Exception("Invalid dimension");

        int[][] temp = new int[l1][l2];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                temp[i][j] = arr[i][j] + mat[i][j];
            }
        }

        return temp;
    }

    int[][] subtractMatrix(int[][] arr) throws Exception {
        int l1 = arr.length;
        int l2 = arr[0].length;

        if (l1 != mat.length || l2 != mat[0].length)
            throw new Exception("Invalid dimension");

        int[][] temp = new int[l1][l2];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                temp[i][j] = arr[i][j] - mat[i][j];
            }
        }

        return temp;
    }

    private int calculate(int[][] a1, int[][] a2, int r, int c) {
        int sum = 0;

        for (int i = 0; i < a1[0].length; i++) {
            sum += a1[r][i] * a2[i][c];
        }

        return sum;
    }

    int[][] scalar_multiplyMatrix(int[][] arr, int n) {
        int l1 = arr.length;
        int l2 = arr[0].length;

        int[][] temp = new int[l1][l2];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                temp[i][j] = n * arr[i][j];
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }

        /*System.out.println("Scalar matrix");
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }*/

        return temp;
    }

    int[][] multiplyMatrix(int[][] arr) throws Exception {
        int l1 = arr.length;
        int l2 = arr[0].length;

        if (l1 != mat[0].length)
            throw new Exception("Invalid dimension");

        int[][] temp = new int[mat.length][l2];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < l2; j++) {
                temp[i][j] = calculate(mat, arr, i, j);
            }
        }

        return temp;
    }

    int[][] transposeMatrix(int[][] arr) {
        int[][] temp = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                temp[i][j] = arr[j][i];
            }
        }

        return temp;
    }

    int[][] adjointMatrix(int[][] arr) throws Exception {
        if (arr.length != arr[0].length)
            throw new Exception("Not a square matrix");

        Cofactor c = new Cofactor();
        Determinant d = new Determinant();
        int sign = 1;
        int l = arr.length;
        int[][] temp = new int[l][l];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {

                if ((i + j) % 2 == 0)
                    sign = 1;
                else
                    sign = -1;

                temp[i][j] = sign * d.det(c.getCofactors(arr, i, j), l - 1);
            }
        }

        return transposeMatrix(temp);
    }

    Fraction[][] inverseMatrix(int[][] arr) throws Exception {
        int l = arr.length;
        Determinant d = new Determinant();

        int determinant = d.det(arr, l);
        System.out.println(determinant);

        arr = adjointMatrix(arr);

        Fraction f[][] = new Fraction[l][l];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                f[i][j] = new Fraction(arr[i][j], determinant);
                f[i][j].simplify();
            }
        }

        return f;
    }

    /*Fraction toRREF(Fraction f[][])
    {
        for(int i=0;i<f.length;i++)
        {
            for(int j=0;j<f[0].length;j++)
            {
                if(i != j)
                {
                    f[i+1][j] = f[i+1][j];
                }
            }
        }
    }*/

    void displayMatrix() {
        for (int[] ints : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();
        }
    }

    /*public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter 1 for multiplication");
        System.out.println("Enter 2 for inverse");
        System.out.println("Enter 3 for Reduced Row Echelon Form");

        int n = in.nextInt();
        switch (n) {
            case 1:
                System.out.println("Enter the m*n dimensions");
                int m1 = in.nextInt();
                int n1 = in.nextInt();
                int[][] arr1 = new int[m1][n1];

                System.out.println("Enter the matrix values");
                for (int i = 0; i < m1; i++) {
                    for (int j = 0; j < n1; j++) {
                        arr1[i][j] = in.nextInt();
                    }
                }

                Matrix mat1 = new Matrix(arr1);

                System.out.println("Enter another matrix dimensions");
                int m2 = in.nextInt();
                int n2 = in.nextInt();
                int[][] arr2 = new int[m2][n2];

                System.out.println("Enter the matrix values");
                for (int i = 0; i < m2; i++) {
                    for (int j = 0; j < n2; j++) {
                        arr2[i][j] = in.nextInt();
                    }
                }

                Matrix mat2 = new Matrix(arr2);

                Matrix mat3 = new Matrix(mat1.multiplyMatrix(mat2.mat));

                System.out.println("Multiplication:");
                mat3.displayMatrix();

                break;

            case 2:
                System.out.println("Enter the m*n dimensions");
                int m3 = in.nextInt();
                int n3 = in.nextInt();
                int[][] arr = new int[m3][n3];

                System.out.println("Enter the matrix values");
                for (int i = 0; i < m3; i++) {
                    for (int j = 0; j < n3; j++) {
                        arr[i][j] = in.nextInt();
                    }
                }

                Matrix mat = new Matrix(arr);

                Fraction f[][] = mat.inverseMatrix(arr);
                System.out.println("Inverse Matrix");
                for (int i = 0; i < f.length; i++) {
                    for (int j = 0; j < f.length; j++) {
                        System.out.print(f[i][j].num + "/" + f[i][j].denom + " ");
                    }
                    System.out.println();
                }

                break;

            case 3:
                System.out.println("Enter the m*n dimensions");
                int m4 = in.nextInt();
                int n4 = in.nextInt();
                Fraction[][] arr4 = new Fraction[m4][n4];

                System.out.println("Enter the matrix values");
                for (int i = 0; i < m4; i++) {
                    for (int j = 0; j < n4; j++) {
                        arr4[i][j].num = in.nextInt();
                        arr4[i][j].denom = 1;
                    }
                }
        }
    }*/
}