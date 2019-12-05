//Time complexity-O(n)
//Space complexity-O(n)
//Ran on leetcode
class Solution {
    public int nthUglyNumber(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int i=0,j=0,k=0;
        while(list.size()<n){
            list.add(Math.min(Math.min(list.get(i)*2,list.get(j)*3),list.get(k)*5));
            if(list.get(list.size() - 1)==list.get(i)*2) ++i;
            if(list.get(list.size() - 1)==list.get(j)*3) ++j;
            if(list.get(list.size() - 1)==list.get(k)*5) ++k;
        }
        return list.get(list.size() - 1);
    }
}