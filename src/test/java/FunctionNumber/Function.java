package FunctionNumber;

public class Function {

    public static void main(String[] args) {
        long a = func(6);
        System.out.println(a);
    }


    public static long func(int n) {
        int res = 1;
        if (n == 1 || n == 0) {
            return 1;
        } else if (n < 0 || n > 1) {
            for (int i = 2; i < n; i++) {
                res *= i;
            }
        }return res;
    }
}



