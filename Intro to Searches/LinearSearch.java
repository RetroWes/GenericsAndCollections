public class LinearSearch{
    public static int linearSearch(int[] arr, int target){
        for(int i = 0; i < arr.length; i++) {               // Loop through the array.
            if(arr[i] == target) {return i;}                // Return the index where {target} is found. 
        }
        return -1;                                          // If {target} is not found, return -1.
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
        int[] arr = {1, 9, 2, 5, 7, 1,0, 3};                                  // Create an array of 8 values.
        int target = 0;                                                       // Create target value to search for.
        int result = linearSearch(arr, target);                               // Save the index of the target value.
        if(result != -1){                                                     // If the target value is found...
            System.out.printf("Element found at index %d\n", result);  // Print where it was found at.
        } else{                                                               // Otherwise...
            System.out.println("Element not found.");                       // Print that the element was not found.          
        }
    }
}