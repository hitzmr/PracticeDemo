package recurisionDemo;

import java.util.Arrays;

public class RecurisionDemo {

	public static void main(String[] args) {
//		System.out.println(addNext(0));
		int[] arr = {2, 3, 4, 5, 1, 5, 2, 9, 5, 6, 8, 3, 1};
//		System.out.println(getMaxEle(arr, 0, 0));
//		bubbleSort(arr, 0, 0);
//		System.out.println(Arrays.toString(arr));
		
		System.out.println(divideSearch(arr, 0, arr.length - 1, 9));
	}
	
	public static int addNext(int number){
		if(number > 100) return 0;
		if(number < 0) return 0;
		return number + addNext(number + 1);
	}
	
	public static int getMaxEle(int[] arr, int max, int startPos){
		if(arr[startPos] > max) max = arr[startPos];
		if(startPos==arr.length-1) return max;
		return(getMaxEle(arr, max, startPos + 1));
	}
	
	public static int[] bubbleSort(int[] arr, int startPos, int times){
		if((arr.length - 1 == startPos + 1) && (times == arr.length-1)){
			return arr;
		} ;
		if(arr[startPos] > arr[startPos + 1]){
			int temp = arr[startPos];
			arr[startPos] = arr[startPos + 1];
			arr[startPos + 1] = temp;
		}
		
		if(arr.length - 2 > startPos){
			startPos += 1;
			return bubbleSort(arr, startPos, times);
		}
		if(arr.length - 2 == startPos){
			times += 1;
			return bubbleSort(arr, 0, times);
		}
		return arr;
	}

	public static int divideSearch(int[] arr, int start, int end, int searchValue){
		if(arr[(start + end)/2] == searchValue){
			return (start + end)/2;
		}else if(arr[(start + end)/2] > searchValue){
			return divideSearch(arr, start, (start + end)/2 - 1, searchValue);
		}else if(arr[(start + end)/2] < searchValue){
			return divideSearch(arr, (start + end)/2 + 1, end, searchValue);
		}
		return -1;
	}
}
