package methodTest;

import java.util.Arrays;

public class InsertSort {

	public static void main(String[] args) {
		int[] arr = {4,1,7,5,9,3};
		InsertSort insertSort = new InsertSort();
//		insertSort.sort1(arr);
		System.out.println(Arrays.toString(insertSort.sort1(arr)));
	}
	
	public void sort(int[] arr){
		int compareIndex;
		int temp;
		for(int i=0; i<arr.length; i++){
			compareIndex = i;
			for(int j=0; j<=i; j++){
				if(arr[compareIndex] < arr[i-j]){
					temp = arr[compareIndex];
					arr[compareIndex] = arr[i-j];
					arr[i-j] = temp;
					compareIndex = i-j;
				}
				
			}
		}
	}
	
	public int[] sort1(int[] sourceArray) {
        // �� arr ���п��������ı��������
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

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
        return arr;
    }
}




/**
 * i=0, compareIndex = 0, j=0
 * 
 * i=1, compareIndex = 1, j=0, arr[1] < arr[1]
 * 						  j=1, arr[1] < arr[0]
 * 
 * i=2, compareIndex = 2, j=0, arr[2] < arr[2]
 * 						  j=1, arr[2] < arr[1]
 * 						  j=2, arr[2] < arr[0]
 * 
 * i=3, compareINdex = 3, j=0, arr[3] < arr[3]
 * 						  j=1, arr[3] < arr[2]
 * 						  j=2, arr[3] < arr[1]
 *                        j=3, arr[3] < arr[0]
 * 
 */
