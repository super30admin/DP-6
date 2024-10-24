class Solution {
    public String longestPalindrome(String s) {
        ArrayList<Character> c = new ArrayList<>();

        for (Character cc : s.toCharArray()){
            c.add(cc);
        }
        int maxResult = 0;
        int leftIdx= 0;
        int rightIdx = 0;

        for (int i = 0; i < c.size(); i++){
            int right = i; int left = i;
            // check for odd
            while(left >= 0 && right < c.size() && c.get(left) == c.get(right)){
                if (right - left + 1 > maxResult){
                    maxResult = right - left + 1;
                    leftIdx = left;
                    rightIdx = right;
                }
                left -= 1;
                right +=1;
            }

            right = i + 1; left = i;
            // check for even

            while(left >= 0 && right < c.size() && c.get(left) == c.get(right)){
                if (right - left + 1 > maxResult){
                    maxResult = right - left + 1;
                    leftIdx = left;
                    rightIdx = right;
                }
                left -= 1;
                right +=1;
            }

        }

        StringBuilder sss = new StringBuilder();

        for (int i = leftIdx; i <= rightIdx; i++){
            sss.append(c.get(i));
        }

        return sss.toString();
    }
}

/// T(C): On^2
/// S(C): Stringbuilder : O(n)
