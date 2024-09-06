package com.ivan.leetcode;

public class Solution_11 {

    public static void main(String[] args) {
        System.out.println(new Solution_11().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public int maxArea(int[] height) {
        int max = 0;
        int h;
        int flag;
        for(int i=0; i< height.length-1; i++){
            for(int j = height.length -1; j > i; j--){
                if(height[i] <= height[j]){
                    h = height[i];
                    flag =0;
                }else {
                    h = height[j];
                    flag = 1;
                }
                int area = h * (j-i);
                if(area > max){
                    max = area;
                }
                if(flag == 0){
                    i++;
                    while(i < j && height[i] <= h){
                        i++;
                    }
                }else {
                    j--;
                    while(i < j && height[j] < h){
                        j--;
                    }
                }
            }
        }
        return max;
    }
}