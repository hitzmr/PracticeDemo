package sortMethod;

import java.util.Arrays;

public class SortMethodDemo {

	public static void main(String[] args) {
		SortMethodDemo smd = new SortMethodDemo();
		int[] sortArray = { 5, 8, 6, 3, 9, 2, 1, 7 };
		System.out.println("before sort: " + Arrays.toString(sortArray));
		// smd.bubbleSort1(sortArray);
		// System.out.println("after bubbleSort1: " +
		// Arrays.toString(sortArray));
		smd.bubbleSort2(sortArray);
		System.out.println("after bubbleSort2: " + Arrays.toString(sortArray));
	}

	public void bubbleSort1(int[] sortArray) {
		int cmptime = 0;
		for (int i = 0; i < sortArray.length; i++) {
			for (int j = i + 1; j < sortArray.length; j++) {
				if (sortArray[i] > sortArray[j]) {
					int temp = sortArray[i];
					sortArray[i] = sortArray[j];
					sortArray[j] = temp;
				}
			}
		}
	}

	public void bubbleSort2(int[] sortArray) {
		int temp = 0;
		for (int i = 0; i < sortArray.length; i++) {
			for (int j = 0; j < sortArray.length - i - 1; j++) {
				if (sortArray[j] > sortArray[j + 1]) {
					temp = sortArray[j];
					sortArray[j] = sortArray[j + 1];
					sortArray[j + 1] = temp;
				}
			}
		}
	}

}
