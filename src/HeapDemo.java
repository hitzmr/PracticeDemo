import java.util.Arrays;


public class HeapDemo {

	public static void main(String[] args) {
		int[] arr = {87,45,78,32,17,65,53,9,122,133};
		buildMaxHeap(arr);
		
		System.out.println(Arrays.toString(arr));

	}
	
	public static void buildMaxHeap(int[] arr){
		for(int parent = (arr.length-2)/2; parent>=0; parent--){
			heapfy(arr, parent);
		}
	}
	
	public static void heapfy(int[] arr, int parent){
		int temp;
		for(int child=2*parent+1; child<arr.length-1; child=2*child+1){
			if(arr[child]<arr[child+1])
				child++;
			
			if(arr[parent] > arr[child])
				break;
			
			if(arr[parent] < arr[child]){
				temp = arr[parent];
				arr[parent] = arr[child];
				arr[child] = temp;
				parent = child;
			}
		}
		
	}

}
