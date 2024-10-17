import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] arr, int startIndex, int endIndex) {     // Method to perform quick sort on an array
        if (startIndex < endIndex) {                                            // Base case: continue sorting until startIndex < endIndex
            int partitionIndex = partition(arr, startIndex, endIndex);          // Get the partition index
            quickSort(arr, startIndex, partitionIndex - 1);                     // Recursively sort the left subarray
            quickSort(arr, partitionIndex + 1, endIndex);                       // Recursively sort the right subarray
        }
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {     // Method to partition the array for quick sort
        int pivot = arr[endIndex];                                              // Choose the pivot element as the last element
        int i = startIndex - 1;                                                 // Initialize the index of the smaller element
        int swapTemp = arr[i + 1];                                              // Temporary variable for swapping

        for (int j = startIndex; j < endIndex; j++) {                           // Iterate through the array
            if (arr[j] <= pivot) {                                              // If current element is less than or equal to pivot
                i++;                                                            // Move to the next element
                swapTemp = arr[i];                                              // Swap elements
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        arr[i + 1] = arr[endIndex];    // Swap the pivot element to its correct position
        arr[endIndex] = swapTemp;
        return i + 1;                  // Return the partition index
    }

    // Method to generate an array of random values
    public static int[] generateRandomValues(int numOfValues, int lowerBound, int upperBound){
        int[] tempArray = new int[numOfValues];                                                                         // Create an array to hold the random values
        Random rand = new Random();                                                                                     // Create a Random object
        for(int i = 0; i < numOfValues; i++) {tempArray[i] = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;}   // Fill the array with pseudo-random values within the specified interval
        return tempArray;                                                                                               // Return the array of random values
    }

    public static void PrintArray(int[] arr){                     // Method to print the elements of an array
        System.out.print("[");                                  // Print opening bracket
        for (int i = 0; i < arr.length; i++) {                    // Iterate through the array
            System.out.print(arr[i]);                             // Print the current element
            if(i != arr.length - 1) {System.out.print(", ");}   // Print comma if not the last element
        }
        System.out.println("]");                                // Print closing bracket
    }

    public static void main(String[] args) {
        int numOfValues = 10000;                                                            // The number of values to be generated
        int lowerBound = 1;                                                                 // The lower bound for the generated numbers.
        int upperBound = 5001;                                                              // The upper bound for the generated numbers.
        int[] arr = generateRandomValues(15, 1, 20);      // Generate an array of 10000 random values between 1 and 5001
        
        quickSort(arr, 0, arr.length - 1);                                       // Sort the array using quick sort
        System.out.print("Sorted Array: ");                                               // Print a message indicating sorted array
        PrintArray(arr);                                                                    // Print the sorted array
    }
}