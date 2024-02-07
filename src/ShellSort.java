//Shell Sort
public class ShellSort implements SortingAlgorithm {
    public int[] sort(int[] input) {
        int n = input.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = input[i];

                int j;
                for (j = i; j >= gap && input[j - gap] > temp; j -= gap)
                    input[j] = input[j - gap];

                input[j] = temp;
            }
        }
        return input;
    }
}
