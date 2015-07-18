package task02;

import java.io.*;
import java.util.*;

public class task02 {

    public static float getAverageMark(int []mass)
    {
        int summ=0;
        for (int i=0; i<mass.length; i++)
        {
            summ=summ+mass[i];
        }
        float avMark=(float)summ/mass.length;
        return avMark;
    }

    public static void writeMark(String name, float avMark, String file)
    {
        try{
            String s="Average mark of "+name+"="+avMark;
            FileWriter fileWriter = new FileWriter(file,true) ;
            fileWriter.write(s+"\n");
            fileWriter.close();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        String file1="src\\task02\\ListOne.txt";
        String file2="src\\task02\\ListTwo.txt";
        String file3="src\\task02\\ListThree.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\task02\\marks.txt"))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
                String[] arrayString = str.split(":");
                String[] arrayStringMark = arrayString[1].split(",");
                int[] mass = new int[arrayStringMark.length];
                for (int i = 0; i < arrayStringMark.length; i++) {
                    mass[i] = Integer.parseInt(arrayStringMark[i].trim());
                }
                float avMark=getAverageMark(mass);
                System.out.println("Average mark of "+arrayString[0]+"="+avMark);
                if(avMark<4)
                {
                    writeMark(arrayString[0], avMark, file1);
                }
                else if(avMark<8)
                {
                    writeMark(arrayString[0], avMark, file2);
                }
                else {
                    writeMark(arrayString[0], avMark, file2);
                }

            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
