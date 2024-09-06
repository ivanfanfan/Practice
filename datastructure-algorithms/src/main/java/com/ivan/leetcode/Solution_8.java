package com.ivan.leetcode;


public class Solution_8 {
    public static void main(String[] args) {
        long  a = 5223372036854775808L;
        System.out.println("A__________B");
    }
    public int myAtoi(String s) {
        int length = s.length();
        char[] chs = new char[length];
        int index = 0;
        int hasDot = 0;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (' ' == ch) {
                continue;
            } else if ((ch <= 'z' && ch >= 'a') || (ch >= 'A' && ch <= 'Z')) {
                break;
            } else if (ch <= '9' && ch >= '1') {
                chs[index++] = ch;
            } else if (ch == '-' || ch == '+') {
                if (index == 0) {
                    chs[index++] = ch;
                } else {
                    break;
                }
            } else if(ch == '.'){
                break;
            }
        }
        if (index == 0 || (index == 1 && (chs[0] == '-' || chs[0] == '+'))) {
            return 0;
        }
        int flag = 1;
        long result = 0;
        long dotNumber = 0;
        for (int i = 0; i < index; i++) {
            if(chs[i] == '-'){
                flag = -1;
                continue;
            }
            if(chs[i] == '+'){
                continue;
            }
            if(chs[i] == '.'){
            }
            result = result * 10 + (chs[i] - '0');

        }
        if(flag == -1){
            result = -result;
        }
        if(result >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(result <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }
}
