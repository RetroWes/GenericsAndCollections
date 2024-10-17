import java.util.Random;

public class RandomArray {
    public int[] randomArray(int numOfElements, int lowerBound, int upperBound){
        Random rand = new Random();
        int[] arr = new int[numOfElements];
        for(int i = 0; i < numOfElements; i++){
            arr[i] = rand.nextInt(lowerBound, upperBound + 1);
        }
        return arr;
    }
}
