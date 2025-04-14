package com.ivan.sort;

public class MergeSort {

    // Main function that sorts arr[1...r] using merge()
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        mergeSort(arr,0,arr.length -1);
    }

    // Recursive function to divide the array into subarrays
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            //find the middle point
            int mid = (left + right) >> 1;
            // Sort first and second halves
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            // Merge the sorted halves
            merge(arr,left,mid,right);
        }
    }

    // Merges two subarrays of arr[]
    private static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of the two subarrays to be merged
        int sizeOfLeft = mid - left + 1;
        int sizeOfRight = right - mid;

        // Create temp arrays
        int[] leftArray = new int[sizeOfLeft];
        int[] rightArray = new int[sizeOfRight];

        // copy data to temporary arrays
        System.arraycopy(arr,left,leftArray,0,sizeOfLeft);
        System.arraycopy(arr,mid+1,rightArray,0,sizeOfRight);

        // Merge the temp arrays
        //Initial indexes of first and second subarrays
        int i = 0, j = 0;

        //Initial index of merged subarray
        int k = left;
        while (i < sizeOfLeft && j < sizeOfRight) {
            if(leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            }else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < sizeOfLeft) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while(j < sizeOfRight) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    // Utility function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Given array:");
        printArray(arr);

        sort(arr);

        System.out.println("\nSorted array:");
        printArray(arr);
    }
}
