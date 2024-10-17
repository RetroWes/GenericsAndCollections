public class test {
    static int linearSearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {1, 3, 2, 7, 1, 10, 8};

        System.out.println(linearSearch(arr, 6));
    }
}
