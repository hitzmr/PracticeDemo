package sortMethod;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		int[] arr = { 5, 4, 3, 2, 1 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr) {
		// ���±�Ϊ1��Ԫ�ؿ�ʼѡ����ʵ�λ�ò��룬��Ϊ�±�Ϊ0��ֻ��һ��Ԫ�أ�Ĭ���������
		for (int i = 1; i < arr.length; i++) {
			// ��¼Ҫ���������
			int tmp = arr[i];
			// ���Ѿ�������������ұߵĿ�ʼ�Ƚϣ��ҵ�����С����
			int j = i;
			while (j > 0 && tmp < arr[j - 1]) {
				arr[j] = arr[j - 1];
				j--;
			}

			// ���ڱ���С����������
			if (j != i) {
				arr[j] = tmp;
			}
		}
	}
}
