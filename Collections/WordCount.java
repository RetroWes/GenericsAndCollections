import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;
import java.io.File;

public class WordCount{
    public static void main(String[] args){
        File file = new File("DeclarationOfIndependence.txt");
        BufferedReader reader;
        HashMap<String, Integer> hMap = new HashMap<>();

        try{
            reader = new BufferedReader(new FileReader(file));
            String text = reader.readLine();
            String modifiedText = text.replaceAll("[^a-zA-Z0-9 ]", "");
            String[] words = modifiedText.split(" ");
            
            for(int i = 0; i < words.length; i++){
                String key = words[i].substring(0, 1).toUpperCase() + words[i].substring(1, words[i].length());
                hMap.putIfAbsent(key, 0);
                hMap.put(key, hMap.get(key) + 1);
            }
            reader.close();
            
            TreeMap<String, Integer> tMap = new TreeMap<>(hMap);
            System.out.println(tMap.entrySet());

            String largestKey = "";
            int largestKeySize = 0;
            for(String key : hMap.keySet()){
                if(hMap.get(key) > largestKeySize){
                    largestKey = key;
                    largestKeySize = hMap.get(key);
                }
            }
            System.out.printf("The largest key, \"%s\", occurs %d times.\n", largestKey, largestKeySize);

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
