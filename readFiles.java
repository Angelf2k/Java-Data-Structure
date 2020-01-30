import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.io.IOException;


public class readFiles {

    public static void main(String[] args)
    {
        //***************************************
        String myName = "Angel Alberto Flores!!!";
        //printing my name
        System.out.println(myName);
        //***************************************
        //Path of the grades file
        //String path="grade.txt";

        String path="E:\\Programming Testing 2019\\Data Structure & Algorithm\\src\\grade.txt";


        //********Valid grades*********
        List<String>listGrades= new ArrayList<>(Arrays.asList("A","A+","A-","B","B+","B-","C","C+","C-","D","F"));

        try {
            Stream<String> lines = Files.lines(Paths.get(path));
            List<String>content=lines.collect(Collectors.toList());
            System.out.println("Class Name= "+content.get(0));
            //remove all the invalid grades
            content.retainAll(listGrades);
            //Counting the numbers of duplicates
            Map<String, Integer> duplicates = new HashMap<String, Integer>();
            for (String x : content) {
                if (duplicates.containsKey(x)) {
                    duplicates.put(x, duplicates.get(x) + 1);
                } else {
                    duplicates.put(x, 1);
                }
            }
            //Print the list of the valid grades
            for (Map.Entry<String, Integer> entry : duplicates.entrySet()) {
                System.out.print(entry.getKey() + " ( " + entry.getValue()+ " ) ");
                //Printing number of asteriscs
                String asteriscs = "";
                for (int i=0; i < entry.getValue(); i++) {
                    asteriscs+= "*";
                }
                System.out.println(asteriscs);
            }

        }catch (IOException e) {
            System.err.format("IOException; %s%n",e);
        }//end of error catch

    }//end of main
}//end of classes