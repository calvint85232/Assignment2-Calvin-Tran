//#8 Tester
public class Tester {
    private final SortingAlgorithm sortingAlgorithm;

    public Tester(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public double singleTest(int size) {
        // creates an array of the given size and fill it with random numbers
        int[] testArray = new int[size];
        for (int i = 0; i < size; i++) {
            testArray[i] = (int) (Math.random() * size);
        }

        // records the time it takes to sort the array
        long startTime = System.nanoTime();
        sortingAlgorithm.sort(testArray);
        long endTime = System.nanoTime();

        // return the time in ms
        return (endTime - startTime) / 1e6;
    }

    public double test(int iterations, int size) {
        double totalTime = 0;
        for (int i = 0; i < iterations; i++) {
            totalTime += singleTest(size);
        }
        double averageTime = totalTime / iterations;
        System.out.println("Average time for " + sortingAlgorithm.getClass().getSimpleName() +
                " to sort an array of size " + size + ": " + averageTime + " ms");
        return averageTime;
    }


    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};
        int iterations = 20;

        // instantiate each sorting algorithm and perform the tests later on
        SortingAlgorithm[] algorithms = {
              new BubbleSort(),
                new InsertionSort(),
                new SelectionSort(),
                new ShellSort(),
                new QuickSort(),
                new MergeSort(),

        };


        // loop over each sorting algorithm
        for (SortingAlgorithm algorithm : algorithms) {
            System.out.println("Testing algorithm: " + algorithm.getClass().getSimpleName());

            // Test each size
            for (int size : sizes) {
                Tester tester = new Tester(algorithm);
                tester.test(iterations, size);
            }

            System.out.println();
        }
    }
}
