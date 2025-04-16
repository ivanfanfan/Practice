package com.ivan.sort;


/**
 * 非递归
 * non-recursive
 */
public class MergeSort2 {
    public static void main(String[] args) {
        int[] original = {6,1,3,4,5,2,8,7};
        partition(original);
    }

    public static void partition(int[] arr){
        int length = arr.length;
        for(int width = 1; width < length ; width *= 2){
            for (int low = 0; low < length; low = low + 2*width){
                int high = Math.min(low + 2*width - 1, length - 1);
                int mid = (low + high) / 2;
                System.out.println("low= " + low + " mid= " + mid + " high= " + high);
                merge(arr, low, mid, high);
            }
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {

    }
}
