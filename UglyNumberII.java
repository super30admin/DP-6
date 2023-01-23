package s30.dp.dp6;

import java.util.*;


//algo: Generate all possible candidates for ugly numbers.

//TC: nlogn, as we are using heap;
//SC: 3*n;
public class UglyNumberII {

    public int nthUglyNumber(int n) {

        PriorityQueue<Long> q = new PriorityQueue();
        Set<Long> store = new HashSet();


        q.add(1l);

        while( n > 1){
            long num = q.poll();

            if(!store.contains(num * 2)){
                q.add(num * 2);
                store.add(num * 2);
            }

            if(!store.contains(num * 3)){
                q.add(num * 3);
                store.add(num * 3);
            }

            if(!store.contains(num * 5)){
                q.add(num * 5);
                store.add(num * 5);
            }

            --n;
        }

        long res = q.remove();

        return (int) res;
    }


   //Algo: generate only required numbers maintaining 3 pointers
    //TC: O(n);
    //SC: O(n);
    public int nthUglyNumber1(int n) {

        List<Integer> store = new ArrayList();

        store.add(1);

        int p2 = 0, p5=0, p3 =0;

        while( store.size() <= n){


            int num2 = 2 * store.get(p2);
            int num3 = 3 * store.get(p3);
            int num5 = 5 * store.get(p5);

            int num = Math.min(num2,
                    Math.min(num3, num5)
            );

            store.add(num);

            if(num == num2){
                p2++;
            }

            if(num == num3){
                p3++;
            }

            if(num == num5){
                p5++;
            }


        }


        return store.get(n-1);
    }
    public static void main(String[] args) {

    }
}
