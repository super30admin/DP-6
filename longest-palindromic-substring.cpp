//Time - O(nxn)
//Space - O(1)
class Solution {
public:
    string longestPalindrome(string s) {
        string retStr = "";
        if(s.size()<2) return s;
        for(int i = 0;i<s.size();i++){
            string str1 = findLongestPalindromeSubstr(i,i,s);
            string str2 = findLongestPalindromeSubstr(i,i+1, s);
            if(str1.size()>str2.size() && str1.size()>retStr.size()){
                retStr = str1;
            }else if(str1.size()<str2.size() && str2.size()>retStr.size()){
                retStr = str2;
            }
            if(retStr.size() == s.size()){
                break;
            }
        }
        return retStr;
    }
    
    string findLongestPalindromeSubstr(int i,int j,string s){
        string str = "";
        int size = s.size();
        while(i>=0 && j<size){
            if(s[i]!=s[j]){
                return s.substr(i+1,j-i-1);
            }
            i--;j++;
        }
        
        return s.substr(i+1,j-i-1);
    }
};