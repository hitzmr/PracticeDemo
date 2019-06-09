package method.sortMethod;

import java.util.Arrays;

public class BucketSort implements MySort{
	private static final InsertSort insertSort = new InsertSort();

    @Override
    public int[] sort(int[] sourceArray) {
        // �� arr ���п��������ı��������
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        try {
			return bucketSort(arr, 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
    }

    private int[] bucketSort(int[] arr, int bucketSize) throws Exception {
        if (arr.length == 0) {
            return arr;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        // ����ӳ�亯�������ݷ��䵽����Ͱ��
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // ��ÿ��Ͱ������������ʹ���˲�������
            bucket = insertSort.sort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }

        return arr;
    }

    /**
     * �Զ����ݣ�����������
     *
     * @param arr
     * @param value
     */
    private int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
