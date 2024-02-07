//#11 K Comparison between other sorting methods
public class KSortedTester {
    private final SortingAlgorithm sortingAlgorithm;

    public KSortedTester(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public double singleTest(int size, int k) {
        // creates an array of the given size and fills it with sequential numbers
        int[] testArray = new int[size];
        for (int i = 0; i < size; i++) {
            testArray[i] = i;
        }

        // generates k-sorted data within the array
        KSort.generateKSorted(testArray);

        // records the time it takes to sort the array
        long startTime = System.nanoTime();
        sortingAlgorithm.sort(testArray);
        long endTime = System.nanoTime();

        // return the time in milliseconds
        return (endTime - startTime) / 1e6;
    }

    public double test(int iterations, int size, int k) {
        double totalTime = 0;
        for (int i = 0; i < iterations; i++) {
            totalTime += singleTest(size, k);
        }
        double averageTime = totalTime / iterations;
        System.out.println("Average time for " + sortingAlgorithm.getClass().getSimpleName() +
                " to sort a " + k + "-sorted array of size " + size + ": " + averageTime + " ms");
        return averageTime;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};
        int iterations = 20;
        int k = 10; // adjust k value as needed

        // instantiate each sorting algorithm and perform the tests later on
        SortingAlgorithm[] algorithms = {
               new BubbleSort(),
                new InsertionSort(),
               new SelectionSort(),
                new ShellSort(),
                new MergeSort(),
               //new QuickSort() ***stack overflow at size 20000
        };

        // loop over each sorting algorithm
        for (SortingAlgorithm algorithm : algorithms) {
            System.out.println("Testing algorithm: " + algorithm.getClass().getSimpleName());

            // test each size with k-sorted data
            for (int size : sizes) {
                KSortedTester tester = new KSortedTester(algorithm);
                tester.test(iterations, size, k);
            }

            System.out.println();
        }
    }
}
