package com.ivan.sort;

public class InsertSort {

    public static int[] insert(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = i -1;
            while(j >= 0 && arr[j] > temp ){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]= temp;
        }
        return arr;
    }


    public static int[] insertionRecursive(int[] arr,int unsortedIndex){
        if(unsortedIndex == arr.length){
            return arr;
        }
        int sortedIndex = unsortedIndex -1;
        int insertValue = arr[unsortedIndex];
        while(sortedIndex >= 0 && arr[sortedIndex] > insertValue){
            arr[sortedIndex+1] = arr[sortedIndex];
            sortedIndex -- ;
        }
        arr[sortedIndex+1] = insertValue;
        return insertionRecursive(arr,unsortedIndex+1);
    }
}
