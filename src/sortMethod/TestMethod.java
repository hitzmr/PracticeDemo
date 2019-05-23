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
		
		MySort mySort = new HeapSort();
		afterSort = mySort.sort(arr);
		System.out.println(Arrays.toString(afterSort));
	}

}
