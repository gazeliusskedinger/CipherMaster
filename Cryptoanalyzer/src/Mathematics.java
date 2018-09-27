public class Mathematics {

    public static int gcd(int a, int b) {
        int tmp = 0;
        if (a < 1 || b < 1) {
            throw new IllegalArgumentException("a or b is less than 1");
        }
        if (b > a){
            tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    /**
     * phi
     * @return
     */

    public int fermatInvI(){
        return 1;
    }

    public int fermatInvII(){
        return 1;
    }

    public int fermatInvIII(){
        return 1;
    }




}
