import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class SetLambda{
    public static void main(String[] args){
        HashSet<Integer> integers = new HashSet<>();
        for(int i = 0; i <= 10; i += 1) {integers.add(i);}    // Fills {integers} with integer values.

        // A modified subset of {integers}.
        Set<Integer> squaredEvenIntegers = integers.stream()  // Declares a new set
            .filter(x -> x % 2 == 0)                          // Filters the even integers in {integers}
            .map(x -> x * x)                                  // Squares each even integer
            .collect(Collectors.toSet());                     // Returns all elements as a Set

        System.out.println(squaredEvenIntegers);              // Print the resulting set.
    }
}