package com.ivan.sort;

public class SelectSort {

    public static int[] select(int[] arr){
        for(int i = arr.length -1; i > 0; i--){
            int max = i;
            for(int j= 0; j < i; j++){
                if(arr[j] > arr[max]){
                    max = j;
                }
            }
            if(max != i){
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }
        return arr;
    }
}
