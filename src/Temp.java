public class Temp {

	public static void main(String[] args) {

//		int[] arrays = { 2, 3, 4, 5, 1, 5, 2, 9, 5, 6, 8, 3, 1 };
//
//		System.out.println("���ںţ�Java3y��"
//				+ findMax(arrays, 0, arrays.length - 1));
//		for(int j = 0; j < 100000000; j++){
//			prt(j);
//		}
		tell();

	}

	/**
	 * �ݹ飬�ҳ���������ֵ
	 * 
	 * @param arrays
	 *            ����
	 * @param L
	 *            ��߽磬��һ����
	 * @param R
	 *            �ұ߽磬����ĳ���
	 * @return
	 */

	public static int findMax(int[] arrays, int L, int R) {

		// ���������ֻ��һ��������ô���ľ��Ǹ������һ��ֵ��
		if (L == R) {
			return arrays[L];
		} else {

			int a = arrays[L];
			int b = findMax(arrays, L + 1, R);// �ҳ���������ֵ

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
