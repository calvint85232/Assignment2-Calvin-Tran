//QuickSort
public class QuickSort implements SortingAlgorithm {
    int partition(int[] input, int low, int high) {
        int pivot = input[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // if current element is smaller than or
            // equal to pivot
            if (input[j] <= pivot) {
                i++;

                // swap input[i] and input[j]
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }

        // swap input[i+1] and input[high] (or pivot)
        int temp = input[i + 1];
        input[i + 1] = input[high];
        input[high] = temp;

        return i + 1;
    }

    void quickSort(int[] input, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, input[pi] is
              now at right place */
            int pi = partition(input, low, high);

            // recursively sort elements before
            // partition and after partition
            quickSort(input, low, pi - 1);
            quickSort(input, pi + 1, high);
        }
    }

    public int[] sort(int[] input) {
        quickSort(input, 0, input.length - 1);
        return input;
    }
}
