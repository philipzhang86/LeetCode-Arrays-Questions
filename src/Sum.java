

public class Sum {

    public static void main(String[] args) {

    }

    public static double func(double x, double a){
        return Math.pow(x,2) -a;
    }

    public static double derivFunc(double input){
        double x = 1;
        double x1 = x - (x*x - input)/(2*x);
        while(x - x1 > 0.00000001 || x - x1 < -0.00000001){
            x = x1;
            x1 = x - (x*x - input)/(2*x);
        }
        return x1;
    }

}
