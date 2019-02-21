/**
 * SearchTimer.java
 * Noam Benkler, 18 February 2019
 *
 * A demonstration of simple timing code for binary and linear searching algorithms.
 */
import java.io.*;
import java.util.*;

public class SearchTimer {
   public static void main(String[] args) {
    String searchKey = args[1];
    LinearSearchableCollection<String, Integer> lsc = new LinearSearchableCollection<String, Integer>();
    BinarySearchableCollection<String, Integer> bsc = new BinarySearchableCollection<String, Integer>();
    File englishWords = new File("sowpods.txt");
        Scanner scanner = null;
        try{
            scanner = new Scanner(englishWords);
        } 
        catch (FileNotFoundException e){
            System.err.println(e);
            System.exit(1);
        }
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            int length = line.length();
            lsc.add(line, length);
            bsc.add(line, length); 
        }
        
        int S = Integer.parseInt(args[0]);

        //linear
        long startTime = System.currentTimeMillis();
        for (int i= 0; i<=S/267751 ;i++){
            lsc.containsKey(searchKey);
        }
        long timeElapsed = System.currentTimeMillis() - startTime;
        
        System.out.format("Using Linear Search: %.4f seconds\n" ,(double)timeElapsed/1000);
    
        if (lsc.containsKey(searchKey)){
            System.out.println("Yay! Found " + searchKey);
        } else{
            System.out.println("Boo! Did not find " + searchKey);
        }

        //binary
        startTime = System.currentTimeMillis();
        for (int i= 0; i<=S/267751 ;i++){
            bsc.containsKey(searchKey);
        }
        timeElapsed = System.currentTimeMillis() - startTime;
        System.out.format("Using Binary Search: %.4f seconds\n",(double)timeElapsed/1000);
    
        if (bsc.containsKey(searchKey)){
            System.out.println("Yay! Found " + searchKey);
        } else{
            System.out.println("Boo! Did not find " + searchKey);
        }
   }
}