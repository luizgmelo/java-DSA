package selectionSort;

public class SelectionSort {
	public static void selectionSort(int[] list) {
		if (list.length == 0) {
			return;
		}

		for (int i = 0; i < list.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < list.length; j++) {
				if (list[minIndex] > list[j]) {
					minIndex = j;
				}
			}
			
			if (minIndex != i) {
				int temp = list[i];
				list[i] = list[minIndex];
				list[minIndex] = temp;
			}
		}
	}
	
	
	
}
