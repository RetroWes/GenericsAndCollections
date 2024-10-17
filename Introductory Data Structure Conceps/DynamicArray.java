public class DynamicArray {
    private int[] array;
    private int size;
    
    public DynamicArray() {
        this.size = 0;
        this.array = new int[size];
    }

    // YOUR CODE HERE

    //-------------------//
    // Utility Functions //
    //-------------------//
    public int checkIfWithinBounds(int index, int upperBound){                              // Adjusts the passed in index if it is beyond the bounds of the array.
        if(index > upperBound) {return upperBound;}                                         // If {index} > {upperBound}, {index} will be set to {upperBound.}
        else if(index < 0) {return 0;}                                                      // If {index} < 0, {index} will be set to 0.
        return index;                                                                       // If {index} is within the bounds of the array, just return the index.
    }

    public static void PrintArray(DynamicArray array){                                      // Prints the array in a clean format.
        System.out.print("[");                                                            // Opening bracket.
        for(int i = 0; i < array.getSize(); i++){                                           // For all elements in {array}...
            System.out.print(array.get(i));                                                 // Print the element.
            if(i != (array.getSize() - 1)) {System.out.print(", ");}                      // Print a comma and a space.
        }                                                                                   // End.
        System.out.println("]");                                                          // Closing bracket + newline.
    }

    //-------------------//
    // Primary Functions //
    //-------------------//
    public int[] add(int num, int index){                                                   // Add an item anywhere to this dynamic array.
        index = checkIfWithinBounds(index, getSize());                                      // {index}'s value is adjusted if it is larger than the size or less than 0.
        int[] newArray = new int[getSize() + 1];                                            // Create a new array with a size of {size + 1}.
        System.arraycopy(getArray(), 0, newArray, 0, index);                 // Copy all items from 0 to {index} (exclusive) from {array} to {newArray}.
        newArray[index] = num;                                                              // Place {num} in {newArray} at the passed in {index}.
        System.arraycopy(getArray(), index, newArray, index + 1 , getSize() - index);       // Copy all items in {array} after {index} to {newArray}.

        setSize(getSize() + 1);                                                             // Increase the {size} counter of this dynamic array.
        setArray(newArray);                                                                 // {array} now points to new {newArray}.
        return getArray();                                                                  // Return {array} with {num} added at {index}.
    }
    public int[] add(int num){                                                              // Add an item to the end of this dynamic array.
        int[] newArray = new int[getSize() + 1];                                            // Create a new array with a size of {size + 1}.
        System.arraycopy(getArray(), 0, newArray, 0, getArray().length);     // Copy all items from {array} to {newArray}.
        newArray[size] = num;                                                               // Place {num} at the end of {newArray}.

        setSize(getSize() + 1);                                                             // Increase the {size} counter of this dynamic array.
        setArray(newArray);                                                                 // {array} now points to new {newArray}.
        return getArray();                                                                  // Return {array} with {num} added at the end.
    }

    public int[] remove(int index){                                                         // Remove any item from this array.
        int[] newArray = new int[getSize() - 1];                                            // Create a new array with a size of {size - 1}.
        System.arraycopy(getArray(), 0, newArray, 0, index);                 // Copy all items from {index} to {index - 1} from {array} to {newArray}.
        System.arraycopy(getArray(), index + 1, newArray, index, getSize() - index - 1);    // Copy all items int {array} after {index} to {newArray}.

        setSize(getSize() - 1);                                                             // Decrease the {size} counter of this dynamic array.
        setArray(newArray);                                                                 // {array} now points to new {newArray}.
        return getArray();                                                                  // Return {array} with {num} added at {index}.
    }
    public void remove(int value, boolean removeAll){                                       // Remove elements by value.
        if(removeAll == true){
            for(int i = 0; i < getSize(); i++){ 
                if(get(i) == value) {
                    remove(i);
                    i -= 1;
                }
            }
        } else{
            for(int i = 0; i < getSize(); i++){
                if(get(i) == value) 
                {
                    remove(i);
                    return;
                };
            }
        }
    }

    //-------------------//
    // Getters & Setters //
    //-------------------//
    public int get(int index) {return getArray()[index];}                                   // Return the value at the passed in {index}.

    public int[] getArray() {return this.array;}                                            // Return the pointer to this array.
    public int getSize() {return this.size;}                                                // Return the size of this array.

    public void setArray(int[] array) {this.array = array;}                                 // Change this array's pointer.
    public void setSize(int size) {this.size = size;}                                       // Change this array's size.

    // Method for demonstration purposes
    public static void main(String[] args) {
            DynamicArray da = new DynamicArray();
            da.add(22, 13);
            da.add(22, 13);
            da.add(6, 2);
            da.add(5, 3);
            da.add(22, 13);
            da.add(3);
            da.add(22, 13);
            da.add(4, 2);
            da.add(22, 13);
            da.add(22, 13);
            da.add(7);
            da.add(0, 0);                
            da.add(1, 7); 
            System.out.println("Element at index 1: " + da.get(1));

            // da.remove(1);
            // System.out.println("Size after removing an element: " + da.getSize());

            PrintArray(da);

            da.remove(22, false);

            PrintArray(da);
        }
    }