package sortMethod;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = { 5, 4, 3, 2, 1, 10, 8, 9, 7 };
		sort(arr);
		System.out.println(Arrays.toString(arr));

	}

	public static void sort(int[] arr){
		// �� arr ���п��������ı��������
		int gap = 1;
		while (gap < arr.length) {
			gap = gap * 3 + 1;
		}

		while (gap > 0) {
			for (int i = gap; i < arr.length; i++) {
				int tmp = arr[i];
				int j = i - gap;
				while (j >= 0 && arr[j] > tmp) {
					arr[j + gap] = arr[j];
					j -= gap;
				}
				arr[j + gap] = tmp;
			}
			gap = (int) Math.floor(gap / 3);
		}

	}
}
