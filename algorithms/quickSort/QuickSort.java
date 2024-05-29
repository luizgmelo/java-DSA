package quickSort;

public class QuickSort {
	public static void partition(int[] values, int left, int right) {
		int pivot = values[left];
		int i = left;
		
		for (int j = i + 1; j <= right; j++) {
			if (values[j] <= pivot) {
				i++;
				swap(values, i, j);
			}
		}
		
		swap(values, i, left);
	}
	
	public static void swap(int[] values, int a, int b) {
		int temp = values[a];
		values[a] = values[b];
		values[b] = temp;
	}
}
