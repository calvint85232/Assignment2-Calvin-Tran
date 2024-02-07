//InsertionSort
public class InsertionSort implements SortingAlgorithm {
    public int[] sort(int[] input) {
        int n = input.length;
        for (int i = 1; i < n; ++i) {
            int key = input[i];
            int j = i - 1;

            /* Move elements of input[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = key;
        }
        return input;
    }
}
