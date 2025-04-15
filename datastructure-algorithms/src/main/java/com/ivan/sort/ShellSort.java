package com.ivan.sort;

public class ShellSort {

    public static int[] shell(int[] arr) {
        for(int gap = arr.length >>> 1; gap > 0; gap=gap >>>1){
            for(int i = gap; i <arr.length; i++){
                int insertValue = arr[i];
                int j = i - gap;
                while(j >= 0 && insertValue < arr[j]){
                    arr[j+gap] = arr[j];
                    j = j -  gap;
                }
                arr[j + gap] = insertValue;
            }
        }
        return arr;
    }
}
