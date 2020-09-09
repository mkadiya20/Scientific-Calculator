package Algebra;

public class QuadraticEqn
{
    Polynomial eqn;
    public QuadraticEqn(Polynomial eqn)
    {
        this.eqn = eqn;
        validate();
    }

    public QuadraticEqn()
    {}

    void validate()
    {
        if(eqn.degree!=2)
        {
            System.out.println("Equation is not quadratic");
        }
    }

    int discriminant()
    {
        int d = eqn.coef[1]*eqn.coef[1];
        d = d - (4*eqn.coef[0]*eqn.coef[2]);
        if(d<0)
        {
            System.out.println("Roots are imaginary");
            return -1;
        }
        return (int)Math.sqrt(d);
    }

    Polynomial equation(int x1,int x2)
    {
        int temp1[] = {-x1,1};
        int temp2[] = {-x2,1};
        Polynomial p1 = new Polynomial(temp1);
        Polynomial p2 = new Polynomial(temp2);

        Polynomial p = p1.multiply(p2);
        p.show();
        return p;
    }

    void roots()
    {
        int d = discriminant();

        int x1 = -1*eqn.coef[1] + d;
        x1 = x1 / (2*eqn.coef[2]);

        int x2 = -1*eqn.coef[1] - d;
        x2 = x2 / (2*eqn.coef[2]);

        System.out.println("Roots: ("+x1+","+x2+")");
    }
}
