package Algebra;

public class Cofactor {
    public int[][] getCofactors(int arr[][], int x, int y) {

        int a = 0, b = 0;
        int temp[][] = new int[arr.length - 1][arr[0].length - 1];

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[0].length; j++) {

                if (x != i && y != j)
                    temp[a][b++] = arr[i][j];

            }

            b = 0;

            if (x != i)
                a++;
        }

        return temp;
    }
}
