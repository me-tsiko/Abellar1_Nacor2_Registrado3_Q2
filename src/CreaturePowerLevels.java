import java.util.Scanner;

public class CreaturePowerLevels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input power levels
        int[] powerLevels = new int[10];
        System.out.println("Enter the power levels of 10 creatures:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Creature " + (i + 1) + ": ");
            powerLevels[i] = scanner.nextInt();
        }

        // Step 2: Bubble Sort in ascending order
        int[] bubbleSorted = bubbleSort(powerLevels.clone());
        System.out.println("\nPower levels sorted in ascending order (Bubble Sort):");
        displayArray(bubbleSorted);

        // Step 3: Selection Sort in descending order
        int[] selectionSorted = selectionSort(powerLevels.clone());
        System.out.println("\nPower levels sorted in descending order (Selection Sort):");
        displayArray(selectionSorted);

        // Step 4: Calculate and display analysis
        int sumEven = 0, sumOdd = 0, min = powerLevels[0], max = powerLevels[0];
        for (int level : powerLevels) {
            if (level % 2 == 0) {
                sumEven += level;
            } else {
                sumOdd += level;
            }
            if (level < min) min = level;
            if (level > max) max = level;
        }

        System.out.println("\nAnalysis:");
        System.out.println("Sum of even power levels: " + sumEven);
        System.out.println("Sum of odd power levels: " + sumOdd);
        System.out.println("Minimum power level: " + min);
        System.out.println("Maximum power level: " + max);

        scanner.close();
    }

    // Bubble Sort Implementation (Ascending Order)
    public static int[] bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    // Selection Sort Implementation (Descending Order)
    public static int[] selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIdx]) {
                    maxIdx = j;
                }
            }
            // Swap elements
            int temp = array[maxIdx];
            array[maxIdx] = array[i];
            array[i] = temp;
        }
        return array;
    }

    // Utility method to display an array
    public static void displayArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}