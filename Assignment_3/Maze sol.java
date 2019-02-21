import java.util.*;
import java.io.*;

public class Maze {
    private ArrayList<ArrayList<MazeSquare>> rowList;
   // [Other instance variables if you need them]
    private int columns;
    private int rows;
    private int startPointX;
    private int startPointY;
    private int endPointX;
    private int endPointY;
    // This can live here as a private inner class, or you could
    // put MazeSquare in its own MazeSquare.java if you prefer.
    private class MazeSquare {
        //[Instance variables of your choosing]
        
        private String symbol;
        
        public MazeSquare(String symbol) {
            this.symbol = symbol;    
        }
        
        //[Whatever methods you need, like:]
        public boolean hasLeftWall(){
            if (symbol.equals("L")) {
                return true;
            } else if (symbol.equals("|")) {
                return true;
            } else {
                return false; 
            }
        }

      public boolean hasBottomWall(){
            if (symbol.equals("L")) {
                return true;
            } else if (symbol.equals("_")) {
                return true;
            } else {
                return false; 
            }
        }
    }

    // Methods for Maze
    public Maze() {
       // Initialize the instance variables here.
     rowList = new ArrayList<ArrayList<MazeSquare>>();
    }

    public void load(String fileName) {
        File file = new File(fileName);
        Scanner scanner = null;
         try {
             scanner = new Scanner(file);
         } 
      catch (FileNotFoundException e) {
             System.err.println(e);
             System.exit(1);
         }

        // Iterate through the file, instantiating new Person objects and adding
        // them to personList.

        ArrayList<MazeSquare> mazeSquareList = new ArrayList<MazeSquare>();
        
        // reading the first three lines 
        int i = 0;
        ArrayList<String> numberArray = new ArrayList<String>();
        while (scanner.hasNextLine() && i<3) {
            String line = scanner.nextLine();
            //Split the information from the text:
            String[] numbers = line.split(" ");
        for(String n : numbers){
            numberArray.add(n);
          }
          i++;
        }
      
        rows = Integer.parseInt(numberArray.get(1));
        columns = Integer.parseInt(numberArray.get(0));
        startPointX = Integer.parseInt(numberArray.get(2));
        startPointY = Integer.parseInt(numberArray.get(3)); 
        endPointX = Integer.parseInt(numberArray.get(4));
        endPointY = Integer.parseInt(numberArray.get(5));
      
      i = 0;
      while(scanner.hasNextLine() && i < rows) {
        String line = scanner.nextLine();
        String[] symbols = line.split("");
        //if (symbols.length < columns)
       //   continue;   // lazy error checking
        //for (int c = 0; c < columns; c++) {
        for (String s : symbols){
          MazeSquare symbol = new MazeSquare(s);
          mazeSquareList.add(symbol);
        }
        rowList.add(mazeSquareList);
        mazeSquareList = new ArrayList<MazeSquare>();
      }
      scanner.close();
    }


    public void print() {
      
      // top wall
      for (int a = 0; a < columns; a++) {
            System.out.print("+-----");
        }
      System.out.println("+");
      
      // for each row
      for(int i = 0; i<rowList.size(); i++){
        ArrayList<MazeSquare> row = rowList.get(i);
            // for the first three lines
            for(int c = 0; c < 3; c++){
              for(int col = 0; col < row.size(); col++){
                MazeSquare sq = row.get(col);
                if(sq.hasLeftWall()){
                  if(c==1 && i == startPointY && col == startPointX){
                System.out.print("|  S  ");
                  }
                  else if(c==1 && i == endPointY && col == endPointX){
                  System.out.print("|  F  ");
                  }
                  else{
                  System.out.print("|     ");
                  }
                }
                else{
                   if(c==1 && i == startPointY && col == startPointX){
                System.out.print("   S  ");
                  }
                  else if(c==1 && i == endPointY && col == endPointX){
                  System.out.print("   F  ");
                  }
                  else{
                  System.out.print("      ");
                  }
                }
              }
              System.out.println("|");
            }
        // for the last line in the row
        for(MazeSquare sq : row){
            if(sq.hasBottomWall()){
              System.out.print("+-----");
            }
          else{
            System.out.print("+     ");
          }
        }
        System.out.println("+");
      }
    }



    // This main program acts as a simple unit test for the
    // load-from-file and print-to-System.out Maze capabilities.
    public static void main(String[] args) {
        if (args.length != 1) {
            //System.err.println("Usage: java Maze mazeFile");
            //System.exit(1);
            //build solution function here.
        }
        else if (args.length ){
            System.err.println("Usage: java Maze mazeFile --showsolution");
            System.exit(2);
        }

        Maze maze = new Maze();
        maze.load(args[0]);
        maze.print();
    }
}