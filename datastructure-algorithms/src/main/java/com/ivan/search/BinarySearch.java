package com.ivan.search;

public class BinarySearch {

    public static int search(int[] a,int target) {
        return recursive(a,target,0,a.length-1);
    }

    private static int recursive(int[] a, int target, int left, int right) {
        if (left > right){
            return -1;
        }
        int mid = (left + right) >>> 1;
        if(target < a[mid]){
            return recursive(a,target,left,mid-1);
        }else if (target > a[mid]){
            return recursive(a,target,mid+1,right);
        }else {
            return mid;
        }
    }

}
