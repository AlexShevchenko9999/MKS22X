import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;
    private int startr = -1, startc = -1;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename){
        //COMPLETE CONSTRUCTOR
	animate = false;
	boolean hasS = false, hasE = false;
	try { 
	    Scanner test = new Scanner (new File(filename));
	    int down=1;
	    int across=0;
	    while (test.hasNextLine()){
		down++;
		if (test.nextLine().length() > across) across = test.nextLine().length();
	    }
  
	    maze = new char[down][across];
	    
	    Scanner sc = new Scanner (new File(filename));
	    for (int row = 0;sc.hasNextLine(); row++){
		String line = sc.nextLine();
		char[] arr = line.toCharArray();
		int col = 0;
		for (char i: arr){
		    if (i == 'E') hasE = true;
		    if (i == 'S') hasS = true;
		    maze[row][col]=i;
		    col ++;
		}
	    }
	    if (!hasE || !hasS) System.exit(0);
	    
	}catch (FileNotFoundException e){
            e.printStackTrace();
            System.exit(0);
        }


    }
	/*for (int col = 0;line.hasNext(); col++){
	    maze[row][col] = line.next().toCharArray();
	    //System.out.println(line.next());
	    }*/

    //===============================================================================================

    public String toString(){
	String ans = "";
	for (int row = 0; row < maze.length; row++){
	    for (int col = 0; col < maze[row].length; col++){
		ans += maze[row][col];
	    }
	    ans += "\n";
	}
	return ans;
    }
    //=============================================================================================== 
    
    private void wait(int millis){ //ADDED SORRY!
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    //===============================================================================================

    public void setAnimate(boolean b){
        animate = b;
    }

    //===============================================================================================

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

    //===============================================================================================

    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
	findS();
	//Initialize starting row and startint col with the location of the S. 
	maze[startr][startc] = ' ';//erase the S, and start solving!
	return solve(startr,startc);
    }


    private void findS (){
	for (int row = 0; row < maze.length; row++){
	    for (int col = 0; col < maze[row].length; col ++){
		if (maze[row][col] == 'S'){
		    startr = row;
		    startc = col;
		}
	    }
	}
    }

    //===============================================================================================
    

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
	if (row >= 0 && 
	    row < maze.length && 
	    col >= 0 && 
	    col < maze[row].length){ 
	    
	    if (maze[row][col] == 'E') return true;
	    //if (maze[row][col] == '@') maze[row][col] = '.';
	    if (maze[row][col] == ' '){
		maze[row][col] = '@';
		if  (solve(row+1, col) || 
		     solve(row-1, col) ||
		     solve(row, col+1) ||
		     solve(row, col-1)) return true;
		maze[row][col] = '.';
		/*else { 
		    return (solve(row+1, col) ||
			    solve(row-1, col) ||
			    solve(row, col+1) ||
			    solve(row, col-1));
			    }*/
	    }
	    
	    //COMPLETE SOLVE
	}
        return false; //so it compiles
    }

    public static void main(String[] args){
	Maze m = new Maze ("data1.dat");
	System.out.println(m.solve());
	System.out.println(m);
	Maze m1 = new Maze("data2.dat");
	m1.solve();
	System.out.println(m1);
	Maze m2 = new Maze("data3.dat");
	m2.solve();
	System.out.println(m2);
    }
}
