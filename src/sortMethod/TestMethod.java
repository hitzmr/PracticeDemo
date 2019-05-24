package sortMethod;

import java.util.Arrays;

public class TestMethod {

	public static void main(String[] args) {
		int[] arr = { 5, 4, 3, 2, 1, 10, 8, 9, 7 };
		int[] afterSort;
//		MySort mySort = new MergeSort();
//		afterSort = mySort.sort(arr);
//		System.out.println(Arrays.toString(afterSort));
		
//		MySort mySort = new QuickSort();
//		afterSort = mySort.sort(arr);
//		System.out.println(Arrays.toString(afterSort));
		
//		MySort mySort = new HeapSort();
//		afterSort = mySort.sort(arr);
//		System.out.println(Arrays.toString(afterSort));
//		
		int[] arr1 = {87,45,78,32,17,65,53,9,122,133};
		MySort my = new HeapSort();
		afterSort = my.sort(arr1);
		System.out.println(Arrays.toString(afterSort));
	}

}
