/**
 * TimingDemo.java
 * Jeff Ondich, 13 February 2019
 *
 * A demonstration of simple timing code.
 */
import java.io.*;
import java.util.*;



public class SearchTimer {
   
   public long binaryTimer(BinarySearchableCollection<String, String> collection){
    long startTime = System.currentTimeMillis();
        for (int k = 0; k < 1000; k++) {
            collection.containsKey("!");
        }
    long timeElapsed = System.currentTimeMillis() - startTime;
    System.out.format("Binary Searching: %.4f seconds\n", (double)timeElapsed / 1000.0);
   }

   public long linearTimer(LinearSearchableCollection<String, String> collection){
    long startTime = System.currentTimeMillis();
        for (int k = 0; k < 1000; k++) {
            collection.containsKey("!");
        }
        long timeElapsed = System.currentTimeMillis() - startTime;
        System.out.format("Linear Searching: %.4f seconds\n", (double)timeElapsed / 1000.0);
   }

   public static void main(String[] args) {
        String englishWords = "sowpods.txt";
        File words = file(englishWords);
        Scanner scan = new Scanner(words);
        int N = Integer.parseInt(args[0]);


        for(int i = 0; i<N; i++){
            scan.hasNextLine();{
                word = scan.nextLine();
                bsc.add(word);
                lsc.add(word);
            }
        }

       BinarySearchableCollection bsc = new BinarySearchableCollection<String, String>();
       int binaryTime = binaryTimer(bsc);

       LinearSearchableCollection lsc = new LinearSearchableCollection<String, String>();
       int linearTime = linearTime(lsc);

   }








   /* public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("To time different efficiencies of search methods input args");
        } else {
            int N = Integer.parseInt(args[0]);
            timeTestStack(new BinarySearchableCollection<String, E>);
            timeTestStack(new LinearSearchableCollection<String, E>);
        }
    }

    private static void timeTestStack(SearchableCollection<String, E> collection, int N) {
        System.out.format("====== Time-testing %s ======\n", collection.getClass().getName());
        long startTime = System.currentTimeMillis();
        for (int k = 0; k < N; k++) {
            collection.containsKey("!");
        }
        long timeElapsed = System.currentTimeMillis() - startTime;
        System.out.format("Pushing: %.4f seconds\n", (double)timeElapsed / 1000.0);
    }*/
}