//time complexity- O(n)
//space complexity- O(n)
public class UglyNumberII {
    static int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 0, n3 = 0, n5 = 0;
        int count = 1;
        int[] temp = new int[n];
        temp[0] = 1;

        while(count != n) {
            n2 = 2*temp[p2];
            n3 = 3*temp[p3];
            n5 = 5*temp[p5];
            int min = Math.min(n2, Math.min(n3, n5));
            temp[count++] = min;

            if(n2 == min) {
                p2++;
            }
            if(n3 == min) {
                p3++;
            }
            if(n5 == min) {
                p5++;
            }
        }
        return temp[n-1];
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Nth ugly number: " + nthUglyNumber(n));
    }
}
