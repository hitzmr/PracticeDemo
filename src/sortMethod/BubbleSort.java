package sortMethod;

import java.util.Arrays;

public class BubbleSort implements MySort{

//	public static void main(String[] args) {
//		int[] arr = {5,4,3,2,1};
//		bubbleSort(arr);
//		System.out.println(Arrays.toString(arr));
//
//	}
	
	@Override
	public int[] sort(int[] arr){
		int temp = 0;
		boolean isSorted;
		int compareTimes = 0;
		for(int i=0; i<arr.length; i++){
			isSorted = true;
			// 其实可以发现比较完一轮之后，数组最后一个元素肯定是最大的，比较完2轮之后数组最后两位肯定是最大且有序的，。。。。
			// 所以在嵌套循环中我们无需遍历到数组的最后一位，只遍历到还没有排序的那一位即可
			for(int j = 0; j<arr.length-1-i; j++){
				if(arr[j]>arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					isSorted = false;
				}
				compareTimes++;
			}
			// 如果比较完一轮之后并没有元素位置的交换，那么说明整个数组已经是有序的了，无需再重复。
			if(isSorted)
				break;
			System.out.println(Arrays.toString(arr));
		}
		System.out.println(compareTimes);
		
		return arr;
	}

}
