package com.ivan.leetcode;

public class Solution {
    public String longestPalindrome(String s) {
        int subStart = 0;
        int subEnd = s.length() -1;
        int max = 0;
        String subString = null;
        for(int i = 0; i <= subEnd -1 ;i++ ){
            for(int j = subEnd; j >= i; j--){
                int m = i, n =j;
                for( ;m<=n;m++,n--){
                    if(s.charAt(m)!=s.charAt(n)){
                        break;
                    }
                }
                if(m > n && j - i > max){
                    max = j -i;
                    subString = s.substring(i,j);
                }
            }
        }
        return subString;
    }
}


