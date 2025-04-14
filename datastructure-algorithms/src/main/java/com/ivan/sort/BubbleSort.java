package com.ivan.sort;

public class BubbleSort {

    public static int[] bubble(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] bubbleRecursive(int[] arr, int sortedIndex){
        if(sortedIndex == 0){
            return arr;
        }
        int x = 0;
        for(int i= 0; i < sortedIndex; i++){
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                x = i;
            }
        }
        return bubbleRecursive(arr, x);
    }
}
