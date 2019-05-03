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
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {

            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
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
