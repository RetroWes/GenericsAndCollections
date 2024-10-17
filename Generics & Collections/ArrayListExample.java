import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Bipedal");                   // Added an element to the array.
        arrayList.add("Crabs");                     // Added anothr element to the array.
        System.out.println(arrayList);                // Output array

        arrayList.set(1, "Kangaroos");  // Modified an element.
        System.out.println(arrayList);                // Output array

        arrayList.remove(0);                    // Removed an element by index.
        System.out.println(arrayList);                // Output array.
        
        arrayList.remove("Kangaroos");              // Removed an element by string value.
        System.out.println(arrayList);                // Output array.
    }
}
