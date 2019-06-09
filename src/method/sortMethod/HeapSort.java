package method.sortMethod;

import java.util.Arrays;

public class HeapSort implements MySort{

//	public static void main(String[] args) {
//		int[] arr = {87,45,78,32,17,65,53,9,122,133};
//		sort(arr);
//		System.out.println("After the heap was sorted : "
//				+ Arrays.toString(arr));
//
//	}

	public static int[] buildMaxHeap(int[] arr) {
		// �Ӷѵ����һ���ڵ㿪ʼ���ҵ��丸�ڵ�,�Ӵ˽ڵ������ѵĸ����ߣ�ȥ����ÿһ���Դ˽ڵ�Ϊ�����ӽڵ�
		int length = arr.length;
		for (int parent = (arr.length - 2) / 2; parent >= 0; parent--) {
			heapfy(arr, parent, arr.length);
		}
		return arr;

	}

	/**
	 *
	 * @param arr
	 * @param parent
	 */
	public static void heapfy(int[] arr, int parent, int length) {
		int temp;

		/**
		 * ע������ѭ�������� child = 2*parent+1�ǵõ����ڵ�����ӽڵ� ѭ������child =
		 * 2*child+1����˼�����ȵõ��ĸ��ڵ�Ϊ���ڵ��ĳ��
		 * ����λ���������Ϊ����-��������ֻ�������������������ˣ����ʱ��������ӻ��к���Ļ�����ô�Ҿ�Ҫȥ�������ӵġ���λ����������-���ӣ���
		 */
		for (int child = 2 * parent + 1; child < length; child = 2 * child + 1) {

			// ע�Ᵽ֤child+1<arr.length����Ϊ��ѭ���������в�û�б�֤��һ�㣬����������Ҫ����ǰ��
			if (child < length - 1 && arr[child] < arr[child + 1])
				child++;

			if (arr[child] <= arr[parent]) {
				break;
			} else {
				temp = arr[child];
				arr[child] = arr[parent];
				arr[parent] = temp;
				// �����길��-���ӵ���֮�󣬾�Ҫ���ڶ���-��������
				parent = child;
			}

		}

	}

	@Override
	public int[] sort(int[] arr) {
		int[] array = buildMaxHeap(arr);
		System.out.println("After the heap was created: "
				+ Arrays.toString(array));
		int temp;
		for (int i = array.length - 1; i >= 1; i--) {
			temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			heapfy(array, 0, i);
		}

		return array;

	}
}