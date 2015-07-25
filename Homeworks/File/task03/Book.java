import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Comparator;

public class Book {

    public static void main(String[] args) {
         Map<String, Integer> hashMap = new HashMap<String, Integer>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\book.txt"))) {
            String str;
            int count = 0;
            while ((str = bufferedReader.readLine()) != null) {
                String[] arrayWords = str.split("[\\W]");
                count = count + arrayWords.length;
                for (int i = 0; i < arrayWords.length; i++) {
                    arrayWords[i] = arrayWords[i].trim();
                    arrayWords[i] = arrayWords[i].toLowerCase();
                    if (hashMap.containsKey(arrayWords[i]))
                    {
                          hashMap.put(arrayWords[i], hashMap.get(arrayWords[i]) + 1);
                    }
                    else
                    {
                        hashMap.put(arrayWords[i],1);
                    }
                  }
            }
                List entryList = new ArrayList(hashMap.entrySet());
                Collections.sort(entryList, new Comparator() {
                    public int compare(Object o1, Object o2) {
                        Map.Entry e1 = (Map.Entry) o1;
                        Map.Entry e2 = (Map.Entry) o2;
                        Comparable c1 = (Comparable) e1.getValue();
                        Comparable c2 = (Comparable) e2.getValue();
                        return c1.compareTo(c2);
                    }
                });
              Collections.reverse(entryList);
              entryList.remove(0);
             for (int i=0; i<20; i++) {
                 System.out.println(entryList.get(i));
             }
            System.out.println("words of text = " + count);
                } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

         }
    }