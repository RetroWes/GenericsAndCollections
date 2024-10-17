import java.util.Arrays;

public class HashTable{
    private HashEntry[] buckets;                                       // An ArrayList that can hold Bucket objects.
    private int size;                                                        // The number of buckets in this HashTable.
    private final HashEntry emptyAfterRemoval = new HashEntry(-1, null); // Marks locations where data was previously removed.

    // Initializes HashTable with the amount of buckets specified.
    public HashTable(int size){
        this.size = size

        for(int i = 0; i < size; i++){
            Bucket newBucket = new Bucket();
            buckets.add(newBucket);
        }

        this.size = size;
    }

    public ArrayList<Bucket> getBuckets() {return buckets;}

    // Essentially just an ArrayList. This class was created solely to enhance readability.
    public class Bucket{
        ArrayList<HashEntry> bucket = new ArrayList<>();
        
        public ArrayList<HashEntry> getHashEntries() {return bucket;}
    }

    // Objects that will store values and be inserted into a Buckets in accordance with the hash function.
    public class HashEntry{
        private int key; 
        private String value;

        public HashEntry(int key, String value){
            this.key = key;
            this.value = value;
        }

        public String getValue() {return value;}
        public void setValue(String value) {this.value = value;}
    }

    public void insert(int key, String value){
        int hash = hashFunction(key);
        int i = 0;
        while(true){
            int index = (hash + (i * i)) % size;    // Quadratic Probing.
            if(buckets.get(index) == null || buckets.get(index) == emptyAfterRemoval){
                buckets[index] = new HashEntry(key, value);
            }
        }

    }

    public int hashFunction(int key){
        return key % size;
    }

    public static void main(String[] args){
        HashTable hTable = new HashTable(10);
        hTable.insert(0, "Hi");
    }
}