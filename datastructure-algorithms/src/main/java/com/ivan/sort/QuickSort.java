package com.ivan.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5,8,3, 2, 1,6,7,4};
        quick(arr, 0, arr.length - 1);
//        System.out.println(pivotIndex);
        System.out.println(Arrays.toString(arr));
    }

    private static void quick(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition3(arr,left,right);
        quick(arr,left,pivot-1);
        quick(arr,pivot+1,right);
    }

    private static int partition2(int[] arr, int left, int right) {
        //to find the element greater  less than pivot
        int i = left;
        // to find the element that less than pivot;
        int j = left;
        int pivot = right;
        while(j < right){
            if(arr[j] < arr[pivot]){
                if(i != j){
                    swap(arr,i,j);
                }
                i++;
            }
            j++;
        }
        swap(arr,i,pivot);
        return i;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 双边快排
     * 1. 为什么内循环需要加 i < j条件
     * 2. 为什么先处理j,再处理i
     */
    private static int partition3(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;
        while(i < j){
            while (i < j && arr[j] > pivot){
                j--;
            }
            while (i < j && arr[i] <= pivot){
                i++;
            }
            swap(arr,i,j);
        }
        swap(arr,left,i);
        return i;
    }

    /**
     * 双边快排
     *  1. 处理相同的元素
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left + 1; // 这里left +1
        int j = right;
        while(i < j){
            while(i <= j && arr[i] < pivot){
                i++;
            }
            while(i <= j && arr[j] > pivot){
                j--;
            }
            if(i <= j){
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        swap(arr,left,j);
        return j;
    }
    public static int partition1(int[] arr, int sortedMiddleIndex, int unsortedIndex, int pivot){
        int pivotValue = arr[pivot];
        while(unsortedIndex < pivot) {
            int currentUnSorted = arr[unsortedIndex];
            if (currentUnSorted >= pivotValue) {
                unsortedIndex++;
            } else {
                int temp = arr[unsortedIndex];
                ++sortedMiddleIndex;
                arr[unsortedIndex] = arr[sortedMiddleIndex];
                arr[sortedMiddleIndex] = temp;
            }
        }
        sortedMiddleIndex++;
        arr[pivot] = arr[sortedMiddleIndex];
        arr[sortedMiddleIndex] = pivotValue;
        return sortedMiddleIndex;
    }

}
