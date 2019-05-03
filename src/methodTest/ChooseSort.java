package methodTest;

import java.util.Arrays;

public class ChooseSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,1,7,5,9,3};
		ChooseSort chooseSort = new ChooseSort();
		chooseSort.sort(arr, arr.length);
		System.out.println(Arrays.toString(arr));

	}
	
	public void sort(int[] arr, int endLength){
		if(endLength == 1) return;
		int maxEleIndex = 0;
		for(int i=0; i<endLength; i++){
			if(arr[i]>arr[maxEleIndex]) maxEleIndex = i;
		}
		
		int temp = arr[maxEleIndex];
		arr[maxEleIndex] = arr[endLength-1];
		arr[endLength-1] = temp;
		sort(arr, endLength-1);
	}

}
