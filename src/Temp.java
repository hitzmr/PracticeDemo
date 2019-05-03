public class Temp {

	public static void main(String[] args) {

//		int[] arrays = { 2, 3, 4, 5, 1, 5, 2, 9, 5, 6, 8, 3, 1 };
//
//		System.out.println("公众号：Java3y："
//				+ findMax(arrays, 0, arrays.length - 1));
//		for(int j = 0; j < 100000000; j++){
//			prt(j);
//		}
		tell();

	}

	/**
	 * 递归，找出数组最大的值
	 * 
	 * @param arrays
	 *            数组
	 * @param L
	 *            左边界，第一个数
	 * @param R
	 *            右边界，数组的长度
	 * @return
	 */

	public static int findMax(int[] arrays, int L, int R) {

		// 如果该数组只有一个数，那么最大的就是该数组第一个值了
		if (L == R) {
			return arrays[L];
		} else {

			int a = arrays[L];
			int b = findMax(arrays, L + 1, R);// 找出整体的最大值

			if (a > b) {
				return a;
			} else {
				return b;
			}
		}

	}

	public static void prt(int num) {
		int temp = 0;

		for (int i = 1; i <= num; i++) {
			if (num % i == 0)
				temp++;
		}

		if (temp == 2) {
			System.out.println(num);
		}
	}
	
	public static void tell(){
		for(int i=0; i<5; i++){
			System.out.println("i = " + i);
		}
		
		for(int j=0; j<5; ++j){
			System.out.println("j = " + j);
		}
	}
	
}
