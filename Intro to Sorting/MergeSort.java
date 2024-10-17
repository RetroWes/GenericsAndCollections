public class MergeSort {
    public static void sort(int[] arr, int low, int high) {
        if(low < high){
            int mid = (low + high) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int subArrSize1 = mid - low + 1;        // Get the size for the lesser subarray.
        int subArrSize2 = high - mid;           // Get the size for the greater subarray.
        int[] tempArr1 = new int[subArrSize1];  // Create an array to store the lesser subarray.
        int[] tempArr2 = new int[subArrSize2];  // Create an array to store the greater subarray.
    
        for (int i = 0; i < subArrSize1; i++) {tempArr1[i] = arr[low + i];}
        for (int j = 0; j < subArrSize2; j++) {tempArr2[j] = arr[mid + 1 + j];}
    
        int i = 0, j = 0, k = low;

        while (i < subArrSize1 && j < subArrSize2) {
            if (tempArr1[i] <= tempArr2[j]) {
                arr[k] = tempArr1[i];
                i++;
            } else {
                arr[k] = tempArr2[j];
                j++;
            }
            k++;
        }
    
        /* Copy remaining elements of tempArr1[] if any */
        while (i < subArrSize1) {
            arr[k] = tempArr1[i];
            i++;
            k++;
        }
    
        /* Copy remaining elements of tempArr2[] if any */
        while (j < subArrSize2) {
            arr[k] = tempArr2[j];
            j++;
            k++;
        }
    }

    public static void PrintArray(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i != arr.length - 1) {System.out.print(", ");}
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arr = {41, 4, 2, 7, 2, 9, 10, 1, -2, 10}; // An array of 10 values.

        int startIndex = 0;
        int endIndex = arr.length - 1;

        sort(arr, startIndex, endIndex);
        System.out.print("Sorted Array: ");
        PrintArray(arr);
    }
}