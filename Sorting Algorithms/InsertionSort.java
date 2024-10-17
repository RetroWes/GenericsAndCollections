public class InsertionSort {
    public static int[] insertionSort(int[] arr){
        ArrayPrinter printer = new ArrayPrinter();
        for(int i = 1; i < arr.length; i++){
            int j = i;
            while(j > 0 && arr[j] < arr[j - 1]){
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
                printer.printArray(arr);    // This allows you to see the algorithm step-by-step.
            }
        }
        return arr;
    }
    
    public static void main(String[] args){
        ArrayPrinter printer = new ArrayPrinter();
        RandomArray rand = new RandomArray();

        int numOfElements = 10;
        int lowerBound = 0;
        int upperBound = 100;
        
        int[] nums = rand.randomArray(numOfElements, lowerBound, upperBound);
        printer.printArray(nums);
        insertionSort(nums);
    }
}
