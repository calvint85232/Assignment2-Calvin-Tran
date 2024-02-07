//Merge Sort
    public class MergeSort implements SortingAlgorithm {
    // ferges two subarrays of input
    void merge(int[] input, int left, int middle, int right) {
        // find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        //copies data to temp arrays*/
        System.arraycopy(input, left, L, 0, n1);
        System.arraycopy(input, middle + 1, R, 0, n2);

        // merge temp arrays

        // initial indexes of first and second subarrays
        int i = 0, j = 0;

        // initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                input[k] = L[i];
                i++;
            } else {
                input[k] = R[j];
                j++;
            }
            k++;
        }

        // copy remaining elements of L if any
        while (i < n1) {
            input[k] = L[i];
            i++;
            k++;
        }

        // copy remaining elements of R if there is any
        while (j < n2) {
            input[k] = R[j];
            j++;
            k++;
        }
    }

    // main function that sorts using the merge
    void sort(int[] input, int left, int right) {
        if (left < right) {
            // finds the middle point
            int middle = left + (right - left) / 2;

            // sort first and second halves
            sort(input, left, middle);
            sort(input, middle + 1, right);

            // merge the sorted halves
            merge(input, left, middle, right);
        }
    }

    @Override
    public int[] sort(int[] input) {
        sort(input, 0, input.length - 1);
        return input;
    }
}
