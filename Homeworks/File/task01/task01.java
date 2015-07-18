package task01;

import java.util.*;
import java.io.*;

public class task01 {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        try(BufferedReader br = new BufferedReader(new FileReader("src\\text.txt")))
        {
            System.out.println("Enter word to find");
            String word=scan.nextLine();

            String str;
            while ((str=br.readLine())!=null) {
                if (str.indexOf(word) != -1) {
                    System.out.println(str);
                }
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}