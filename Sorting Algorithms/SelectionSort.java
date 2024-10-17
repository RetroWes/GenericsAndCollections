public class SelectionSort{
    public static int[] selectionSort(int[] arr){
        ArrayPrinter printer = new ArrayPrinter();
        int temp;
        for(int i = 0; i < arr.length; i++){
            boolean swap = false;;
            int smallestIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[smallestIndex]) {
                    smallestIndex = j;
                    swap = true;
                }
            }
            temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;

            if(swap) {printer.printArray(arr);}    // This allows you to see the algorithm step-by-step.
        }
        return arr;
    }

    public static void main(String[] args){
        ArrayPrinter printer = new ArrayPrinter();
        RandomArray rand = new RandomArray();
        
        int numOfElements = 1000;
        int lowerBound = 0;
        int upperBound = 100;
        
        int[] nums = rand.randomArray(numOfElements, lowerBound, upperBound);
        printer.printArray(nums);

        selectionSort(nums);
    }
}