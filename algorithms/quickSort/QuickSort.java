package quickSort;

public class QuickSort {
	public static void quickSort(int[] values, int left, int right) {
		if (left < right) {
			int pivot = partitionHoare(values, left, right);
			quickSort(values, left, pivot - 1);
			quickSort(values, pivot + 1, right);
		}
	}
	// Lomuto partition
	public static int partitionLomuto(int[] values, int left, int right) {
		int range = right - left + 1;
		int rand_pivot_index = (int)(Math.random() * range) + left;
		
		swap(values, left, rand_pivot_index);
		
		int pivot = values[left];
		int i = left;
		
		for (int j = i + 1; j <= right; j++) {
			if (values[j] <= pivot) {
				i++;
				swap(values, i, j);
			}
		}
		
		swap(values, i, left);
		
		return i;
	}
	
	// Hoare partition
	public static int partitionHoare(int[] values, int left, int right) {
		int pivot = values[left];
		int i = left + 1;
		int j = right;
		
		while (i <= j) {
			while (i <= j && values[i] <= pivot) {
				i++;
			}
			
			while (i <= j && values[j] > pivot) {
				j--;
			}
			
			if (i < j) {
				swap(values, i, j);
			}
		}
		
		swap(values, left, j);
		
		return j;
	}
	
	public static void swap(int[] values, int a, int b) {
		int temp = values[a];
		values[a] = values[b];
		values[b] = temp;
	}
}
