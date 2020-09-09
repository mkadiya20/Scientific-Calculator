package Arithmetic;

public class LCM {

    int getLCM(int a, int b) {
        int lcm = (a > b) ? a : b;
        while(true)
        {
            if(lcm%a==0&&lcm%b==0)
                return lcm;
            ++lcm;
        }
    }
}
