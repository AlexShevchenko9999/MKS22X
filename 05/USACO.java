
import java.util.*;
import java.io.*;
public class USACO {
    private int[][] lake;
    private int ROW,COL,E,TIMES;

    //BRONZE================================================================================================================== 
    //BRONZE================================================================================================================== 
    //BRONZE================================================================================================================== 

    /*
      [4, 6, 22, 2]
      
          0   1   2   3   4   5
      1 [28, 25, 20, 32, 34, 36]
      2 [27, 25, 20, 20, 30, 34]
      3 [24, 20, 20, 20, 20, 30]
      4 [20, 20, 14, 14, 20, 20]
      
      [1, 4, 4]
      [1, 1, 10]
    */
    
    public int bronze(String filename){
	try {
            Scanner lakeScan = new Scanner(new File(filename));
            Scanner firstLine = new Scanner (lakeScan.nextLine());
	    ROW = Integer.parseInt(firstLine.next());
	    COL = Integer.parseInt(firstLine.next());
	    E = Integer.parseInt(firstLine.next());
	    TIMES = Integer.parseInt(firstLine.next());

	    lake = new int[ROW][COL];
	    for (int r = 0; r < ROW; r ++){
		Scanner lakeScanLine = new Scanner(lakeScan.nextLine());
		for (int c = 0; c < COL; c++){
		    lake[r][c] = Integer.parseInt(lakeScanLine.next());
		}
	    }
	    
            while (TIMES > 0) {
                Scanner lakeScanLine = new Scanner(lakeScan.nextLine());
                int startRow = Integer.parseInt(lakeScanLine.next())-1;
		int startCol = Integer.parseInt(lakeScanLine.next())-1;
		int dig = Integer.parseInt(lakeScanLine.next());
		while (dig > 0){
		    findMax(startRow,startCol);
		    dig--;
		}
		TIMES--;
            }
        }
	catch (FileNotFoundException e) {
            System.out.println("Lake not found! Please insert a valid lake file!");
            System.exit(1);
        }
	//=======================================================================

	
	for (int r = 0; r < ROW; r ++){
	    for (int c = 0; c < COL; c++){
		if (lake[r][c] >= E) lake[r][c] = 0;
		else lake[r][c] = E - lake[r][c];
	    }
	}
	int total = 0;
	for (int r = 0;r < ROW; r ++){
            for(int c = 0; c <COL; c++){
		total += lake[r][c];
	    }
	}
	return total * 5184;
    }

	
    private void findMax(int r, int c){
	ArrayList<Integer> nums = new ArrayList<Integer>();
	
	for (int row = r; row <= ROW;row++){
	    for (int col = c; col < COL; col++){
		if (row < (r + 3) && col < (c + 3)) nums.add(lake[row][col]);
	    }
	}

	int max = nums.remove(0);
	for (int i : nums) 
	    if (i > max) max = i;

	digOne(r,c,max);
    }



    public void digOne(int r, int c, int max){
	for(int row = r; row <= ROW;row++){
	    for (int col = c; col < COL; col++){
		if (row < (r + 3) && col < (c + 3) && lake[row][col] == max) lake[row][col] --;
	    }
	}
    }

    //SILVER==================================================================================================================
    //SILVER================================================================================================================== 
    //SILVER================================================================================================================== 
    //SILVER================================================================================================================== 

    /*
      4 5 6
      ...*.
      ...*.
      .....
      .....
      1 3 1 5
    */

    private int[][] field;
    private int N,M,T,R1,C1,R2,C2;
    private int[][] placeHolder;
    /*
      N = 4;
      M = 5;
      T = 6;
      R1 = 1, C1 = 3;
      R2 = 1, C2 = 5;
     */
    

    public int silver(String filename){
	try {
            Scanner inScan = new Scanner(new File(filename));
            Scanner firstLine = new Scanner(inScan.nextLine());
	    N = Integer.parseInt(firstLine.next());
	    M = Integer.parseInt(firstLine.next());
	    T = Integer.parseInt(firstLine.next());
	    field = new int[N][M];
	    for (int row = 0; row < N; row++){
		Scanner line = new Scanner(inScan.nextLine());
		line.useDelimiter("");
		for (int col = 0; col < M;col++){
		    if (line.next().equals(".")) field[row][col] = 0;
		    else field[row][col] = -1;
		}
	    }
	   
	    Scanner lastLine = new Scanner(inScan.nextLine());
	    //String lastLine = inScan.nextLine();
	    //System.out.println(fieldToString());
	    R1 = Integer.parseInt(lastLine.next())-1;
	    C1 = Integer.parseInt(lastLine.next())-1;
	    R2 = Integer.parseInt(lastLine.next())-1;
	    C2 = Integer.parseInt(lastLine.next())-1;
	    field[R1][C1] = 1;
	    placeHolder = new int[N][M];
	    toPlace();
	    //System.out.println(arrToString(field));
        }
        catch (FileNotFoundException e) {
            System.out.println("Lake not found! Please insert a valid lake file!");
            System.exit(1);
        }
	//=======================================================================================
	return solveSilver();
	
    }

    private void toPlace(){
	for (int r = 0; r < N; r ++){
	    for (int c = 0; c < M; c++){
		placeHolder[r][c] = field[r][c];
	    }
	}
    }

    private void toField(){
	for (int r = 0;r < N; r ++){
            for(int c = 0; c <M; c++){
		field[r][c] = placeHolder[r][c];
            }
	}
    }

    private int solveSilver(){
	for (int i = 0; i < T; i++){
	    for (int r = 0; r < N; r ++){
		for (int c = 0; c < M ; c++){
		    //if (field[row][col] == 0) add(row,col);
		    //else if (field[row][col] != -1) field[row][col] = 0;
                    int total = 0;
		    if (r + 1 < N && field[r+1][c]!=-1) total += field[r+1][c];
		    if (r - 1 >= 0 && field[r-1][c]!=-1) total += field[r-1][c];
		    if (c + 1 < M && field[r][c+1]!=-1) total += field[r][c+1];
		    if (c - 1 >= 0 && field[r][c-1]!=-1) total += field[r][c-1];
		    //System.out.println(fieldToString());
		    if (field[r][c] != -1) placeHolder[r][c] = total;
		}
	    }
	    toField();
	    //System.out.println(arrToString(field));
	}
	//System.out.println(fieldToString());
	return field[R2][C2];
    }

	    

    private static int[] StringtoInt(String[] str) {
	int[] ans = new int[str.length];
	for (int i = 0; i < str.length; i++) ans[i] = Integer.parseInt(str[i]);
	return ans;
    }

    
    private String arrToString(int[][] field){
	String ans = "";
	for (int r = 0; r < N; r ++){
	    for (int c = 0; c < M; c ++){
		ans += field[r][c] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[] args) {
	USACO l = new USACO();
	
	//for (int[] i : l.lake) System.out.println(Arrays.toString(i));
	//System.out.println(l.silver(args[0]));
    }
}
