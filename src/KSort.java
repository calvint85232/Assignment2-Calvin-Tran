//#11 compared only shell sort in this one refer to KSortedTester for others
public class KSort {
    // shell sort implemnetation
    public static int[] shellSort(int[] input) {
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

    // method to generate 10-sorted data
    public static void generateKSorted(int[] array) {
        int n = array.length;
        int k = 10; // Set k to 10 for 10-sorted data

        // use shell sort with gap of k
        for (int gap = k; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
        }
    }

    // method to generate random or 10-sorted data
    public static int[] generateData(int size, boolean isRandom) {
        int[] data = new int[size];
        if (isRandom) {
            for (int i = 0; i < size; i++) {
                data[i] = (int) (Math.random() * size); // random data between 0 and size-1
            }
        } else {
            for (int i = 0; i < size; i++) {
                data[i] = i; // pre sorting
            }
            generateKSorted(data); // makes it 10-sorted
        }
        return data;
    }

    // sorts the data using array.sort
    public static void sortData(int[] data) {
        shellSort(data);
    }

    // measures the time
    public static double measureTime(int size, boolean isRandom) {
        int[] data = generateData(size, isRandom);
        long startTime = System.nanoTime();
        sortData(data);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        // convert nanoseconds to milliseconds
        return elapsedTime / 1e6;
    }

    // main method to perform experiments
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000}; // Example sizes
        for (int size : sizes) {
            double timeRandom = measureTime(size, true);
            double time10Sorted = measureTime(size, false);
            System.out.println("Size: " + size + ", Random Time: " + timeRandom + " ms, 10-Sorted Time: " + time10Sorted + " ms");
        }
    }
}

