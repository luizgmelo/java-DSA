package selectionSort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SelectionSortTest {

	@Test
	void testSelectionSort() {
		int[] my_array = new int[] {1, 5, 3, 4, 2};
		SelectionSort.selectionSort(my_array);
		Assert.assertArrayEquals(my_array, new int[] {1, 2, 3, 4, 5});
		
		my_array = new int[] {44, 22, 11, 23, 65, 87, 90, 110, 221, 53, 86, 43, 12, 90};
		SelectionSort.selectionSort(my_array);
		Assert.assertArrayEquals(my_array, new int[] {11, 12, 22, 23, 43, 44, 53, 65, 86, 87, 90, 90, 110, 221});
		
		my_array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		SelectionSort.selectionSort(my_array);
		Assert.assertArrayEquals(my_array, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		
		my_array = new int[] {5, 5, 5, 5, 3, 3, 2, 2, 3, 3, 4, 4, 5, 6, 6};
		SelectionSort.selectionSort(my_array);
		Assert.assertArrayEquals(my_array, new int[] {2, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6});
	}

}
