import java.util.List;

public class Wildcard {
    // Prints out a generic list in a neat format.
    public static void printList(List<?> list) {
        System.out.print("[");
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i));
            if(i != list.size() - 1) {System.out.print(", ");}
            else {System.out.println("]");}
        }
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(35, 82, 12, 93, 105);           // A list of Integers.
        List<String> stringList = List.of("Soup", "is", "for", "dinosaurs");   // A list of Strings.

        printList(integerList);
        printList(stringList);
    }
}