package countingSort;

public class CountingSort {	
	public static int[] countingSort(int[] v) {
		
		int[] vcul = culmulative(frequency(v));
		int[] sorted_array = new int[v.length]; 
		
		for (int i = v.length - 1; i >= 0; i--) {
			sorted_array[vcul[v[i]-1]-1] = v[i];
			vcul[v[i]-1] -= 1;
		}
			
		return sorted_array;
	}
	
	public static int[] frequency(int[] v) {
		// k is max value of v
		int k = maxValue(v);
		int[] vfreq = new int[k]; 
		
		for (int i = 0; i < v.length; i++) {
			vfreq[v[i] - 1] += 1;
		}
		
		return vfreq;
	}
	
	public static int maxValue(int[] v) {
		int max = v[0];
		for (int i = 0; i < v.length; i++) {
			if (v[i] > max) {
				max = v[i];
			}
		}
		return max;
	}
	
	public static int[] culmulative(int[] vfreq) {
		for (int i = 1; i < vfreq.length; i++) {
			vfreq[i] = vfreq[i] + vfreq[i - 1];
		}
		
		return vfreq;
	}
}
