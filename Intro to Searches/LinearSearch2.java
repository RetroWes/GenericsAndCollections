import java.util.Random;

public class LinearSearch2{
    public static int linearSearch(int[] arr, int target){
        for(int i = 0; i < arr.length; i++) {               // Loop through the array.
            if(arr[i] == target) {return i;}                // Return the index where {target} is found. 
        }
        return -1;                                          // If {target} is not found, return -1.
    }

    public static int[] generateRandomValues(int numOfValues, int lowerBound, int upperBound){
        int[] tempArray = new int[numOfValues];                                                      // An array that can hold {numOfValues} elements.
        Random rand = new Random();                                                                  // A Random Object.
        for(int i = 0; i < numOfValues; i++) {tempArray[i] = rand.nextInt(lowerBound, upperBound);}  // Fills {tempArray} with psudeo-random values within the interval [{lowerBound}, {upperBound})
        return tempArray;                                                                            // Returns the array of psuedo-random values.
    }

    //-------------------//
    // Utility Functions //
    //-------------------//
    // Prints the passed in array in a neat format.
    public static void printArray(int[] arr){
        System.out.print("[");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i != arr.length - 1) {System.out.print(", ");}
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        int numOfValues = 1000000;                                                           // The number of values to fill the array with.
        int lowerBound = 1;                                                                  // The lower bound for the generated values (inclusive).
        int upperBound = 10001;                                                              // The upperBound for the generated values (exclusive).
        int[] arr = generateRandomValues(numOfValues, lowerBound, upperBound);               // Create an array of {numOfValues} values generated within the interval [lowerBound, upperBound).

        int target = 10;                                                                     // Create target value to search for.
        int result = linearSearch(arr, target);                                              // Save the index of the target value.

        
        if(result != -1) {System.out.printf("Element found at index %d\n", result);}  // If the target value is found, print where it was found at.
        else {System.out.println("Element not found.");}                                   // If the target value was not found, print that it was not found.
    }
}