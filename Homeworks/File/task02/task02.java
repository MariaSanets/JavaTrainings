package task02;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Marks {

    public static float getAverageMark(int mass[])
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

    public static void writeMark(String name, String s, String file)
    {
        try{
            FileWriter fileWriter = new FileWriter(file,true);
            fileWriter.write("\n");
            fileWriter.write(s+"\n");
            fileWriter.close();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public static boolean test(String s)
    {
        boolean flag=false;
        String regex="[1-9]";
        String regex2="[1][0]";
        Pattern pattern = Pattern.compile(regex);
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher = pattern.matcher(s);
        Matcher matcher1 = pattern2.matcher(s);
        if(matcher.matches()==true)
        {
            flag=true;
        }
        else if (matcher1.matches()==true)
        {
            flag=true;
        }

        return flag;
    }

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        String file1="src\\ListOne.txt";
        String file2="src\\ListTwo.txt";
        String file3="src\\ListThree.txt";
        String error="src\\error.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\myFile.txt"))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
                String[] arrayString = str.split(":");
                String[] arrayStringMark = arrayString[1].split(",");
                int[] mass = new int[arrayStringMark.length];
                for (int i = 0; i < arrayStringMark.length; i++) {
                    if (test(arrayStringMark[i].trim())==true) {
                        mass[i] = Integer.parseInt(arrayStringMark[i].trim());
                    }
                    else {
                        writeMark(arrayString[0], arrayStringMark[i], error);
                         }
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
