package inverseSearch;

public class DevideSearchDemo {
	Object a = new Object();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(binarySearch(arr, 0, arr.length-1, 3));

	}
	
	public static  int binarySearch(int[] arr, int startIndex, int endIndex, int searchValue){
		if (arr[(startIndex + endIndex)/2] == searchValue){
			return (startIndex + endIndex)/2;
		}else if (arr[(startIndex + endIndex)/2] < searchValue){
			return binarySearch(arr, (startIndex + endIndex)/2 +1, endIndex, searchValue);
		}else if (arr[(startIndex + endIndex)/2] > searchValue){
			return binarySearch(arr, startIndex, (startIndex + endIndex)/2 -1, searchValue);
		}
		return 0;
	}

}
