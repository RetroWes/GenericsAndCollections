import java.util.HashSet;
import java.util.Iterator;

public class SetIterators {
        public static void main(String[] args){
        HashSet<Integer> integers = new HashSet<>();
        for(int i = 0; i <= 10; i += 1) {integers.add(i);}  // Fills {integers} with integer values.

        Iterator<Integer> iter = integers.iterator();       // Iterator object for iterating through the set.
        while(iter.hasNext()){                              // Checks if the set has more elements.
            int next = iter.next();                         // Assigns the next element into a variable.
            if(next % 2 == 0) {System.out.println(next);}   // Checks if the assigned element is even. If so, it gets printed out.
        }
    }
}
