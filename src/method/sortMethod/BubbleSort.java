package method.sortMethod;

import java.util.Arrays;

public class BubbleSort implements MySort{

//	public static void main(String[] args) {
//		int[] arr = {5,4,3,2,1};
//		bubbleSort(arr);
//		System.out.println(Arrays.toString(arr));
//
//	}
	
	@Override
	public int[] sort(int[] arr){
		int temp = 0;
		boolean isSorted;
		int compareTimes = 0;
		for(int i=0; i<arr.length; i++){
			isSorted = true;
			// ��ʵ���Է��ֱȽ���һ��֮���������һ��Ԫ�ؿ϶������ģ��Ƚ���2��֮�����������λ�϶������������ģ���������
			// ������Ƕ��ѭ�������������������������һλ��ֻ��������û���������һλ����
			for(int j = 0; j<arr.length-1-i; j++){
				if(arr[j]>arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					isSorted = false;
				}
				compareTimes++;
			}
			// ����Ƚ���һ��֮��û��Ԫ��λ�õĽ�������ô˵�����������Ѿ���������ˣ��������ظ���
			if(isSorted)
				break;
			System.out.println(Arrays.toString(arr));
		}
		System.out.println(compareTimes);
		
		return arr;
	}

}
