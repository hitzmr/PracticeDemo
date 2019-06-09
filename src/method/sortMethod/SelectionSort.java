package method.sortMethod;

import java.util.Arrays;

public class SelectionSort implements MySort{

//	public static void main(String[] args) {
//		int[] arr = {5,4,3,2,1};
//		selectionSort(arr, arr.length-1);
//		System.out.println(Arrays.toString(arr));
//	}

	@Override
	public int[] sort(int[] arr){
		selectionSort(arr, arr.length-1);
		return arr;
	}
	public int[] selectionSort(int[] arr, int endIndex) {
		if(endIndex < 1)
			return arr;
		int maxIndex = 0;
		for(int i=0; i<=endIndex; i++){
			if(arr[i] > arr[maxIndex])
				maxIndex = i;
		}
		int temp = arr[maxIndex];
		arr[maxIndex] = arr[endIndex];
		arr[endIndex] = temp;
		maxIndex = endIndex;
		
		System.out.println(Arrays.toString(arr));
		selectionSort(arr, endIndex-1);
		return arr;
	}

}
