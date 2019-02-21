/**
 * Timing.java
 * Brianna Fitzpatrick and Elisa Loy, 18 February 2019
 *
 * A demonstration of simple timing code for binary and linear search algorithms.
 */


import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Timing{
    public static void main(String[] args){

        String searchKey = args[1];
            
        //Adding N words to the Binary and the linear list we make
        LinearSearchableCollection<String, Integer> linearStringCollection = new LinearSearchableCollection<String, Integer>();
        BinarySearchableCollection<String, Integer> binaryStringCollection = new BinarySearchableCollection<String, Integer>();
        
        int N = Integer.parseInt(args[0]);
        int i = 0;
        
        
        File inputFile = new File("sowpods.txt");
        Scanner scanner = null;
        try{
            scanner = new Scanner(inputFile);
        } 
        catch (FileNotFoundException e){
            System.err.println(e);
            System.exit(1);
        }
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            int length = line.length();
            linearStringCollection.add(line, length);
            binaryStringCollection.add(line, length); 
        }

        

        
        //Linear Search Timer
        long startTime = System.currentTimeMillis();
        for (int j= 0; j<=N/267751 ;j++){
            linearStringCollection.containsKey(searchKey);
        }
        long timeElapsed = System.currentTimeMillis() - startTime;
        
        System.out.format("Pushing with Linear Search: %.4f seconds\n" ,(double)timeElapsed/1000);
    
        if (linearStringCollection.containsKey(searchKey)){
            System.out.println("Yay! Found " + searchKey);
        } else{
            System.out.println("Boo! Did not find " + searchKey);
        }
        
        
        //Binary Search Timer
        startTime = System.currentTimeMillis();
        for (int j= 0; j<=N/267751 ;j++){
            binaryStringCollection.containsKey(searchKey);
        }
        timeElapsed = System.currentTimeMillis() - startTime;
        System.out.format("Pushing with Binary Search: %.4f seconds\n",(double)timeElapsed/1000);
        
    
        if (binaryStringCollection.containsKey(searchKey)){
            System.out.println("Yay! Found " + searchKey);
        } else{
            System.out.println("Boo! Did not find " + searchKey);
        }
        
    }
}
