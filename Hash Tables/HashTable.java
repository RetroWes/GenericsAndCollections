import java.util.Arrays; // Importing the Arrays class for utility methods, like fill().

public class HashTable{
    private HashEntry[] table; // Array that acts as the storage for hash entries.
    private int size; // The number of slots in the hash table.
    private final HashEntry emptyAfterRemoval = new HashEntry(-1, null); // A special marker HashEntry for removed elements.

    // Constructor that initializes the hash table with a given number of slots.
    public HashTable(int size){
        this.size = size;
        this.table = new HashEntry[size];
        Arrays.fill(table, null); // Initializes all slots in the table to null.
    }

    // Nested class representing individual entries in the hash table.
    public class HashEntry{
        private int key; // The key of the hash entry.
        private String value; // The value associated with the key.

        public HashEntry(int key, String value){
            this.key = key;
            this.value = value;
        }
    }

    // Searches for a value by its key.
    public String search(int key) {
        int hash = hashFunction(key);                                                   // Compute the hash of the key.
        for (int i = 0; i < size; i++) {
            int index = (hash + (i * i)) % size;                                        // Quadratic probing to handle collisions.
            HashEntry entry = table[index];
            if (entry == null) {return null;}                                           // Slot is empty, stop search.
            if (entry != emptyAfterRemoval && entry.key == key) {return entry.value;}   // Key found, return value.
        }
        return null;  // Key not found.
    }

    // Removes a key-value pair from the hash table.
    public void remove(int key) {
        int hash = hashFunction(key);                                                                       // Compute the hash of the key.
        for (int i = 0; i < size; i++) {
            int index = (hash + (i * i)) % size;                                                            // Quadratic probing to handle collisions.
            HashEntry entry = table[index];
            if (entry == null) {return;}                                                                    // Slot is empty, key does not exist.
            if (entry != emptyAfterRemoval && entry.key == key) {table[index] = emptyAfterRemoval; return;} // Key found, mark as removed.
        }
    }
    
    // Inserts a new key-value pair into the hash table.
    public void insert(int key, String value){
        int hash = hashFunction(key);                                        // Compute the hash of the key.
        int i = 0;
        while(true){
            int index = (hash + (i * i)) % size;                             // Quadratic probing to find an empty slot.
            if(table[index] == null || table[index] == emptyAfterRemoval){   // Empty or previously removed slot found.
                table[index] = new HashEntry(key, value);                    // Insert new HashEntry.
                return;
            }
            i++;
            if(i == size){ System.out.println("INSERTION FAILED: Either the table is full or a slot could not be found."); return;} // Table is full.
        }

    }

    // Hash function that computes the hash of a key.
    public int hashFunction(int key){
        return key % size; // Simple modulus-based hash function.
    }

    // Main method to test the HashTable functionality.
    public static void main(String[] args){
        HashTable hTable = new HashTable(10); // Create a HashTable with 10 slots.
        
        // Inserting key-value pairs.
        hTable.insert(0, "Hi");
        hTable.insert(1, "my");
        hTable.insert(2, "name");
        hTable.insert(3, "is");
        hTable.insert(4, "not");
        hTable.insert(5, "Bill");

        // Print all non-null values in the hash table.
        for(int i = 0; i < hTable.size; i++){
            if(hTable.search(i) != null) {System.out.printf("%s ", hTable.search(i));}
        }
        System.out.println();

        hTable.remove(4); // Remove the entry with key 4.

        // Print all non-null values in the hash table after removal.
        for(int i = 0; i < hTable.size; i++){
            if(hTable.search(i) != null) {System.out.printf("%s ", hTable.search(i));}
        }
        System.out.println();
    }
}