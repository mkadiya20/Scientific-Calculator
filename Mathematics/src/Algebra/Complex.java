package Algebra;

public class Complex {
    int re,img;
    public Complex(int re,int img)
    {
        this.re = re;
        this.img = img;
    }

    Complex plus(Complex comp)
    {
        Complex c = new Complex(0,0);
        c.re = re + comp.re;
        c.img = img + comp.img;
        return c;
    }

    Complex subtract(Complex comp)
    {
        Complex c = new Complex(0,0);
        c.re = re - comp.re;
        c.img = img - comp.img;
        return c;
    }
}
