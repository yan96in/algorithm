package algorithm.sort;

public class BinarySort {
	private int[] array;

	public BinarySort(int[] array) {
		this.array = array;
	}

	public void sort() {
		if (array == null) {
			throw new RuntimeException("array is null");
		}

		if (array.length > 0) {
			for (int i = 1; i < array.length; i++) {
				int temp = array[i];
				int insertIndex = binarySearch(i - 1, temp);
				if (i != insertIndex) {
					for (int j = i - 1; j >= insertIndex; j--) {
						array[j] = array[j - 1];
					}
					array[insertIndex] = temp;
				}
			}
		}

	}

	private int binarySearch(int maxIndex, int data) {
		int start = 0;
		int end = maxIndex;
		int mid = -1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (array[mid] > data) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
}
