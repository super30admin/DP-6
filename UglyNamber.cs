using System;
using System.Collections.Generic;
using System.Text;

namespace Array
{
    public class UglyNamber
    {
        /*
         * T.C: O(N) where n is number 
         * S.C: O(N)
         */
        public int NthUglyNumber(int n)
        {
            if (n == 1) return 1;

            int[] unum = new int[] { 2, 3, 5 };
            int p2 = 0, p3 = 0, p5 = 0;
            int n2 = 2, n3 = 3, n5 = 5;
            int[] result = new int[n];
            result[0] = 1;
            int min = 0;

            for (int i = 1; i < n; i++)
            {
                min = Math.Min(n2, Math.Min(n3, n5));
                result[i] = min;
                if (n2 == min)
                {
                    p2++;
                    n2 = result[p2] * 2;
                }
                if (n3 == min)
                {
                    p3++;
                    n3 = result[p3] * 3;
                }
                if (n5 == min)
                {
                    p5++;
                    n5 = result[p5] * 5;
                }
            }

            return result[n - 1];

        }
    }
}
