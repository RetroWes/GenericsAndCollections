import java.util.LinkedList;
import java.util.Iterator;

public class ListManager<T> {
    public static <T> LinkedList<T> ReverseLinkedList(LinkedList<T> linkedList){
        LinkedList<T> reversedList = new LinkedList<>();
        Iterator<T> iter = linkedList.descendingIterator();

        while(iter.hasNext()) {reversedList.add(iter.next());}
        return reversedList;
    }

    public static void main(String[] args){
        // A list of students.
        LinkedList<String> students = new LinkedList<>();
        students.add("Wesley");
        students.add("Carlos");
        students.add("Micah");
        students.add("Mike");
        students.add("Alex");
        students.add("Joseph");
        students.add("Grant");
        students.add("Masar");
        students.add("Amy");
        students.add("Alan");

        students.forEach(x -> System.out.println(x));   // Print each student.
        System.out.println();                           // Newline.

        students.remove(students.size() - 2);           // Remove the second-to-last student.
        students.forEach(x -> System.out.println(x));   // Print each student.
        System.out.println();                           // Newline.

        students.removeLast();                          // Remove the last student.
        students.forEach(x -> System.out.println(x));   // Print each student.
        System.out.println();                           // Newline.

        LinkedList<String> reversedStudents = ReverseLinkedList(students);  // The same list of students, but in reverse order.
        reversedStudents.forEach(x -> System.out.println(x));               // Print out each student.
        System.out.println();                                               // Newline.

        System.out.printf("First Element: %s\nLast Element: %s", reversedStudents.getFirst(), reversedStudents.getLast());  // Print the first and last students in the list.
    }
}
