import java.util.*;
import java.io.*;

public class Maze {
    private ArrayList<ArrayList<MazeSquare>> rowList;

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
        private int col;
        private int row;
        private boolean visited;
        
        public MazeSquare(String symbol, int row, int col, boolean visited) {
            this.symbol = symbol;
            this.row = row;
            this.col = col;
            this.visited = visited;
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
        
        public int getRow() {
            return row;
        }
    
        public int getCol() {
            return col;
        }
        
        public void setVisit() {
            visited = true;
        }
        
        public boolean checkVisit() {
            return visited;
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
      
      int rowCount = 0;
        int colCount = 0;
      while(scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] symbols = line.split("");
        //if (symbols.length < columns)
       //   continue;   // lazy error checking
        //for (int c = 0; c < columns; c++) {
        for (String s : symbols){
          MazeSquare symbol = new MazeSquare(s, rowCount, colCount, false);
          mazeSquareList.add(symbol);
            colCount++;
        }
        colCount = 0;
        rowCount++;
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
//            System.out.print(sq.getRow());
//            System.out.print(sq.getCol());
//             sq.setVisit();
//            System.out.print(sq.checkVisit());
//            MazeSquare curSquare = rowList.get(startPointX).get(startPointY);
//            path.push(curSquare)); 
//            int currentX = startPointX; 
//            int currentY = startPointY; 
//            curSquare.setVisit();
//            System.out.print(sq.checkVisit());
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
    
    //--------------------------------------
    
    public boolean noLeftWall(MazeSquare sq) {
        int targetX = sq.getRow();
        int targetY = sq.getCol() -1;
        MazeSquare targetSquare = rowList.get(targetX).get(targetY);
        if (!isInMaze(targetSquare) || targetSquare.hasLeftWall()) {
            return false;
        }
        return true;
    }
    
    public boolean noRightWall(MazeSquare sq) {
        int targetX = sq.getRow();
        int targetY = sq.getCol() + 1;
        MazeSquare targetSquare = rowList.get(targetX).get(targetY);
        if (!isInMaze(targetSquare) || targetSquare.hasLeftWall()) {
            return false;
        }
        return true;
    }
    
    public boolean noBottomWall(MazeSquare sq) {
        int targetX = sq.getRow() + 1;
        int targetY = sq.getCol();
        MazeSquare targetSquare = rowList.get(targetX).get(targetY);
        if (!isInMaze(targetSquare) || targetSquare.hasBottomWall()) {
            return false;
        }
        return true;
    }
    
    public boolean noTopWall(MazeSquare sq) {
        int targetX = sq.getRow() - 1;
        int targetY = sq.getCol();
        MazeSquare targetSquare = rowList.get(targetX).get(targetY);
        if (!isInMaze(targetSquare) || targetSquare.hasBottomWall()) {
            return false;
        }
        return true;
    }

    public boolean isInMaze(MazeSquare sq) {
        if (sq.getCol() < columns && sq.getRow() < rows) {
            return true; 
        }
        return false; 
        }
    
    public boolean isFinalSquare(MazeSquare sq) {
        if (sq.getCol() == endPointY && sq.getRow() == endPointX) {
            return true;
        }
        return false;
    }
    
    public void solveMaze () { 
        //create stack 
        Stack<MazeSquare> path = new Stack<MazeSquare>();
        
        MazeSquare startSquare = rowList.get(startPointX).get(startPointY);
        path.push(startSquare); 
        startSquare.setVisit();
        
        MazeSquare finalSquare = rowList.get(endPointX).get(endPointY);
        
        MazeSquare currentSquare = path.peek(); 
        
        int currentX = startPointX; 
        int currentY = startPointY; 
                
        while (path.size() != 0 && !currentSquare.equals(finalSquare)) {
            currentSquare = path.peek(); 
            int nextX, nextY; 
//            MazeSquare nextSquare = rowList.get(nextY).get(nextX);
            
            // Check for InMaze, noWall, and notVisited | when to change visited[x][y] = true? 
            // moving right: 
            if ((currentSquare.getCol() != columns - 1) && (currentSquare.getCol() < columns)) {
                
                nextY = currentSquare.getCol() + 1; 
                MazeSquare nextSquare = rowList.get(currentX).get(nextY);
                
                if (isInMaze(nextSquare) && noRightWall(nextSquare) && nextSquare.checkVisit()) {
                    path.push(nextSquare);
                    for (MazeSquare p : path) {
                        System.out.println(p);
                    }
                    currentSquare = nextSquare; 
                    nextSquare.setVisit();
                }
            }
                        
            //moving down: 
            if (currentSquare.getRow() != rows - 1 && currentSquare.getRow() < rows) {
                nextX = currentSquare.getRow() + 1; 
                MazeSquare nextSquare = rowList.get(nextX).get(currentY);
                
//                System.out.println("Hello");
//                System.out.println(nextX);
//                System.out.println(currentY);
                
                if (isInMaze(nextSquare) && noBottomWall(currentSquare) && nextSquare.checkVisit()) {
                    path.push(nextSquare);
                    currentSquare = nextSquare;
                    nextSquare.setVisit();
                }
            }
        
            //moving left:
            if (currentSquare.getCol() != 0 && currentSquare.getCol() < columns) {
                nextY = currentSquare.getCol() - 1; 
                System.out.println(nextY);
                MazeSquare nextSquare = rowList.get(currentX).get(nextY);
                
                if (isInMaze(nextSquare) && noLeftWall(currentSquare) && nextSquare.checkVisit()) {
                    path.push(nextSquare);
                    currentSquare = nextSquare;
                    nextSquare.setVisit();
                }
            }
            
            //moving up:
            if (currentSquare.getRow() != 0 && currentSquare.getRow() < rows){
                nextX = currentSquare.getRow() - 1; 
                MazeSquare nextSquare = rowList.get(nextX).get(currentY);
                
                if (isInMaze(nextSquare) && noTopWall(nextSquare) && nextSquare.checkVisit()) {
                    path.push(nextSquare);
                    currentSquare = nextSquare;
                    nextSquare.setVisit();
                    } 
            } else { 
                path.pop();
                if (!path.isEmpty())
                currentSquare = path.peek();
                }
        }

        System.out.println(path.size());
    }
    

    
    public static void main(String[] args) {
            Maze maze = new Maze();
            maze.load(args[0]);
            maze.print();
    
            if (args[1].contains("--showsolution")) {
                maze.solveMaze();
            } 
    }
}

    