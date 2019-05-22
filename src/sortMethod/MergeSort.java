package sortMethod;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 5, 4, 3, 2, 1, 10, 8, 9, 7 };
		for(int i=0; i<= arr.length/2; i++){
			mergeSort(Arrays.copyOfRange(arr, i, to))
		}
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	
	public static int[] mergeSort(int[] arr1, int[] arr2){
		int[] ret = new int[arr1.length + arr2.length];
		int index = 0;
		for(int i =0; i<arr1.length; i++){
			for(int j=0; j<arr2.length; j++){
				if (arr1[i] < arr2[j]){
					ret[index] = arr1[i];
				}else{
					ret[index] = arr2[j]; 
				}
			}
		}
		return ret;
	}

}
