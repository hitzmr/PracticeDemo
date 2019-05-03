package methodTest;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// int[] arr = {4,1,7,5,9,3};
		int[] arr = { 1, 2, 3, 4, 6, 5 };
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.bubbleSort(arr);
//		bubbleSort.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public void bubbleSort(int[] arr) {
		int compareCount = 0;
		int temp = 0;
		boolean isSorted = false;
		for (int i = 0; i < arr.length; i++) {
			isSorted = true;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSorted = false;
				}
				compareCount++;
			}
			if (isSorted)
				break;
		}
		System.out.println(compareCount);
	}

	public void bubbleSort1(int[] arr) {
		int temp = 0;
		boolean isSorted = true;
		int lastExchangePos = 0;
		int sortBorder = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			isSorted = true;
			for (int j = 0; j < sortBorder; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSorted = false;
					lastExchangePos = j;
				}
			}
			sortBorder = lastExchangePos; // when the whole array already
											// sorted, break.
			if (isSorted)
				break;
			System.out.println("After " + i + " times sort : "
					+ Arrays.toString(arr));
		}
	}

	private static void sort(int array[])

	{

		int tmp = 0;
		int compareCount = 0;

		for (int i = 0; i < array.length; i++)

		{

			// 有序标记，每一轮的初始是true

			boolean isSorted = true;

			for (int j = 0; j < array.length - i - 1; j++)

			{

				if (array[j] > array[j + 1])

				{

					tmp = array[j];

					array[j] = array[j + 1];

					array[j + 1] = tmp;

					// 有元素交换，所以不是有序，标记变为false

					isSorted = false;

				}
				compareCount++;

			}

			if (isSorted) {

				break;

			}

		}
		
		System.out.println(compareCount);

	}
}
