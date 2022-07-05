using System;
using System.Collections.Generic;
using System.Text;

namespace DynamicProgramming
{
    public class LongestPalindromicSubString
    {
        /*
         * T.C: O(n2) where n is chars in the string
         * S.C: O(n2)
         */
        public string LongestPalindrome(string s)
        {
            if (s == null || s.Length == 0) return "";

            int n = s.Length;
            int max = 0;
            int start = 0;
            int end = 0;

            bool[,] dp = new bool[n, n];

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j <= i; j++)
                {
                    if (s[i] == s[j])
                    {
                        if ((i - j - 1) <= 1 || dp[i - 1, j + 1])
                        {
                            dp[i, j] = true;
                            if (max < i - j + 1)
                            {
                                max = i - j + 1;
                                start = j;
                                end = i;
                            }
                        }
                    }
                }
            }

            Console.WriteLine("start " + start + "end " + end);
            return s.Substring(start, end - start + 1);
        }


        /*
         * T.C: O(n2)
         * S.C: O(1) since all variables used
         * 
         */
        int max, start, end;
        public string LongestPalindrome1(string s)
        {
            if (s == null || s.Length == 0) return "";

            int n = s.Length;
            max = 0;
            start = 0;
            end = 0;

            for (int i = 0; i < n; i++)
            {
                expandAroundCenter(s, i, i);

                if (i + 1 < s.Length && s[i] == s[i + 1])
                {
                    Console.WriteLine("insde if");
                    expandAroundCenter(s, i, i + 1);
                }

            }

            return s.Substring(start, end - start + 1);
        }

        public void expandAroundCenter(string s, int left, int right)
        {
            while (left >= 0 && right < s.Length && s[left] == s[right])
            {
                left--;
                right++;
            }

            left++;
            right--;

            if (right - left + 1 > max)
            {
                max = right - left + 1;
                start = left;
                end = right;

            }
        }


    }
}
