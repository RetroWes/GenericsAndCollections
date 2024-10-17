import java.util.HashSet;

public class SetOperations {
    public static void main(String[] args){
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // Fills {set1} & {set2} with int values.
        for(int i = 0; i <= 10; i += 1) {set1.add(i);}
        for(int i = 5; i <= 15; i += 1) {set2.add(i);}

        // Clones of {set1} so each operation can be demonstrated.
        HashSet<Integer> clone1 = new HashSet<>(set1);
        HashSet<Integer> clone2 = new HashSet<>(set1);
        HashSet<Integer> clone3 = new HashSet<>(set1);

        // Demonstration of each operation.
        System.out.printf("Set 1: %s\nSet 2: %s\n", set1, set2);   // Header
        clone1.addAll(set2);                                              // Union Operation
        System.out.printf("(Set 1) ∪ (Set 2): %s\n", clone1);      // Print Result
        clone2.retainAll(set2);                                           // Intersection Operation
        System.out.printf("(Set 1) ∩ (Set 2): %s\n", clone2);      // Print Result
        clone3.removeAll(set2);                                           // Difference Operation
        System.out.printf("(Set 1) / (Set 2): %s\n", clone3);      // Print Result
        

    }
}
