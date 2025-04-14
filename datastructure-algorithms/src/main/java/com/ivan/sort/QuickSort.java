package com.ivan.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5,8,3, 2, 1,6,7,4};
        int pivotIndex = partition(arr,-1,0,arr.length-1);
        System.out.println(pivotIndex);
    }
    public static int partition(int[] arr, int sortedMiddleIndex, int unsortedIndex, int pivot){
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
