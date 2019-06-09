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
		// 从堆的最后一个节点开始，找到其父节点,从此节点逐渐往堆的根部走，去调整每一个以此节点为根的子节点
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
		 * 注意理解此循环的作用 child = 2*parent+1是得到父节点的左子节点 循环递增child =
		 * 2*child+1的意思是以先得到的父节点为根节点的某个
		 * “单位树”（理解为父亲-儿子这种只有两代的树）调整完了，这个时候如果儿子还有后代的话，那么我就要去调整儿子的“单位树”（儿子-孙子）了
		 */
		for (int child = 2 * parent + 1; child < length; child = 2 * child + 1) {

			// 注意保证child+1<arr.length，因为在循环的条件中并没有保证这一点，所以在这里要放在前面
			if (child < length - 1 && arr[child] < arr[child + 1])
				child++;

			if (arr[child] <= arr[parent]) {
				break;
			} else {
				temp = arr[child];
				arr[child] = arr[parent];
				arr[parent] = temp;
				// 调整完父亲-儿子的树之后，就要调节儿子-孙子树了
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