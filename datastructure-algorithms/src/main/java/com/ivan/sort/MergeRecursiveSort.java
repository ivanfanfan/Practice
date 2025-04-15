package com.ivan.sort;

import java.util.Arrays;


/**
 * TODO 好他妈的恶心!
 */
public class MergeRecursiveSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 7, 9, 5, 8, 4, 6};
        int[] exp = new int[arr.length];
        partition(arr, 0, arr.length - 1, exp, 0);
        System.out.println(Arrays.toString(exp));

//        int[] arr = {3,2,1};
    }

    public static void partition(int[] arr, int left, int right, int[] exp, int k) {
        if(left == right){
            return;
        }
        int mid = (left + right) / 2;
        partition(arr, left, mid, exp, k);
        System.out.println("left = " + left + ", right = " + right);
        partition(arr, mid + 1, right, exp, k);
        System.out.println("left = " + left + ", right = " + right);
        mergeRecursive(arr, left, mid, mid + 1, right, left, exp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeRecursive(int[] original, int left, int leftEnd, int right, int rightEnd, int k, int[] exp) {
        if (left > leftEnd) {
            while (right <= rightEnd) {
                exp[k++] = original[right++];
            }
            return;
        }
        if (right > rightEnd) {
            while (left <= leftEnd) {
                exp[k++] = original[left++];
            }
            return;
        }
        if (original[left] < original[right]) {
            exp[k++] = original[left++];
            mergeRecursive(original, left, leftEnd, right, rightEnd, k, exp);
        }
        if (original[right] < original[left]) {
            exp[k++] = original[right++];
            mergeRecursive(original, left, leftEnd, right, rightEnd, k, exp);
        }
        System.arraycopy(exp,left,original,left,rightEnd - left + 1);
    }
}
