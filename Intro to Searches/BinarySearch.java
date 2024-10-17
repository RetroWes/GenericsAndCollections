import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target){
        Arrays.sort(arr);                                                  // Sorts the passed in array so a binary search can be used.
        return binarySearchRecursion(arr, target, 0, arr.length - 1);  // Begins the binary search.
    }

    public static int binarySearchRecursion(int[] arr, int target, int low, int high){
        int mid = (high + low) / 2;                                                            // The middle index.

        if(target == arr[mid]) {return mid;}                                                   // If the value at the {mid} index of the array equals {target}, return {mid}.
        if(high == low){return -1;}                                                            // If {high} equals {low}, {target} is not in the array.
        else if(target < arr[mid]) {return binarySearchRecursion(arr, target, low, mid);}  // If the value at the {mid} index of the array is less than {target}, search to the left of the {mid} index.
        else {return binarySearchRecursion(arr, target, mid + 1, high);}                       // If the value at the {mid} index of the array is greater than {target}, search to the right of the {mid} index.
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
        int[] arr = {51, 123, 3, 91, 100, 10, 924};
        int target = 10;
        int result = binarySearch(arr, target);

        if(result != -1) {System.out.printf("Element found at index %d\n", result);}
        else {System.out.println("Element not found.");}

        printArray(arr);
    }
}
