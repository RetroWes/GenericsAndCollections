import java.util.HashMap;

public class Map {
    public static void main(String[] args){
        HashMap<String, Integer> empIds = new HashMap<>();

        empIds.put("John", 0301);
        empIds.put("Tony", 3441);
        empIds.put("Tyler", 9521);
        empIds.put("Frank", 5911);
        empIds.put("Goku", 1112);

        System.out.println(empIds);
        System.out.println(empIds.get("Goku"));
        System.out.println(empIds.containsKey("Tyler"));
        System.out.println(empIds.containsKey("Caterpie"));
        System.out.println(empIds.containsValue(9521));
        System.out.println(empIds.containsValue(9999));

        empIds.put("Goku", 1113);
        System.out.println(empIds);

        empIds.replace("Jotaro", 0000);
        System.out.println(empIds);

        empIds.putIfAbsent("John", 2222);
        System.out.println(empIds);

        empIds.putIfAbsent("Cooper", 9999999);
        System.out.println(empIds);  

        empIds.remove("John");
        System.out.println(empIds);
    }
}