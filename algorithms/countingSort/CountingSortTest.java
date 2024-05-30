package countingSort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import insertionSort.InsertionSort;

class CountingSortTest {

	@Test
	void testFrequency() {
		int[] C = CountingSort.frequency(new int[] {1, 9, 1, 3, 4, 7, 6, 7});
		Assert.assertArrayEquals(C, new int[] {2, 0, 1, 1, 0, 1, 2, 0, 1});
	}
	
	@Test
	void testCulmulative() {
		int[] C = CountingSort.culmulative(new int[] {2, 0, 1, 1, 0, 1, 2, 0, 1});
		Assert.assertArrayEquals(C, new int[] {2, 2, 3, 4, 4, 5, 7, 7, 8});
	}
	
	@Test
	void testCountingSort() {
		int[] my_array = new int[] {1, 5, 3, 4, 2};
		my_array = CountingSort.countingSort(my_array);
		Assert.assertArrayEquals(my_array, new int[] {1, 2, 3, 4, 5});
		
		my_array = new int[] {44, 22, 11, 23, 65, 87, 90, 110, 221, 53, 86, 43, 12, 90};
		my_array = CountingSort.countingSort(my_array);
		Assert.assertArrayEquals(my_array, new int[] {11, 12, 22, 23, 43, 44, 53, 65, 86, 87, 90, 90, 110, 221});
		
		my_array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		my_array = CountingSort.countingSort(my_array);
		Assert.assertArrayEquals(my_array, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		
		my_array = new int[] {5, 5, 5, 5, 3, 3, 2, 2, 3, 3, 4, 4, 5, 6, 6};
		my_array = CountingSort.countingSort(my_array);
		Assert.assertArrayEquals(my_array, new int[] {2, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6});
	}
}
