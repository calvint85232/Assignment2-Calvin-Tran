//Selection Sort
public class SelectionSort implements SortingAlgorithm {
    public int[] sort(int[] input) {
        int n = input.length;

        // one by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (input[j] < input[min_idx])
                    min_idx = j;

            // swap the found minimum element with the first
            // element
            int temp = input[min_idx];
            input[min_idx] = input[i];
            input[i] = temp;
        }
        return input;
    }
}
