public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for(int i = 1; i < arr.length; i++){
                if(arr[i] < arr[i - 1]){
                    sorted = false;
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
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

        bubbleSort(arr);
        System.out.print("Sorted Array: ");
        PrintArray(arr);
    }
}