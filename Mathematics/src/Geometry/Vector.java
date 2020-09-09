package Geometry;

import Algebra.Determinant;
import Algebra.Cofactor;

public class Vector {

    int i, j, k;

    public Vector(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public Vector plus(Vector vect) {
        Vector v = new Vector(0, 0, 0);
        v.i = i + vect.i;
        v.j = j + vect.j;
        v.k = k + vect.k;
        return v;
    }

    public Vector minus(Vector vect) {
        Vector v = new Vector(0, 0, 0);
        v.i = i - vect.i;
        v.j = j - vect.j;
        v.k = k - vect.k;
        return v;
    }

    public Vector scalar_multiply(int n) {
        Vector v = new Vector(0, 0, 0);
        v.i = i * n;
        v.j = j * n;
        v.k = k * n;
        return v;
    }

    public int scalar_product(Vector vect) {
        return i * vect.i + j * vect.j + k * vect.k;
    }

    public Vector vector_product(Vector vect) {
        Vector v = new Vector(0, 0, 0);
        int mat[][] = {{1, 1, 1}, {i, j, k}, {vect.i, vect.j, vect.k}};
        Cofactor c = new Cofactor();
        Determinant d = new Determinant();

        v.i = d.det(c.getCofactors(mat, 0, 0), 2);
        v.j = -d.det(c.getCofactors(mat, 0, 1), 2);
        v.k = d.det(c.getCofactors(mat, 0, 2), 2);
        return v;
    }

    public Vector unitVector() {
        return scalar_multiply(1 / magnitude());
    }

    public int magnitude() {
        int mag = i * i + j * j + k * k;
        return (int) Math.sqrt(mag);
    }

    public int scalarProjection(Vector v1, Vector v2) //v1 on v2
    {
        return (v1.scalar_product(v2)) / v2.magnitude();
    }

    public Vector vectorProjection(Vector v1, Vector v2) //v1 on v2
    {
        Vector v = new Vector(0,0,0);
        int dot = v1.scalar_product(v2);
        double total = dot / Math.pow(v2.magnitude(),2);
        return v2.scalar_multiply((int)total);
    }
}
