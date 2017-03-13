
import java.util.*;
import java.io.*;
public class USACO {
    private int[][] lake;
    private int ROW,COL;

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
    
    public int solveB(String filename){
	try {
            Scanner lakeScan = new Scanner(new File(filename));
            int i = 0;
            while (lakeScan.hasNextLine()) {
                lakeScan.nextLine();
                i++;
            }
            lake = new int[i][];
            lakeScan = new Scanner(new File(filename));
            for (int j = 0; j < lake.length; j++) {
                String lakeScanLine = lakeScan.nextLine();
                lake[j] = StringtoInt(lakeScanLine.split(" "));
            }
            ROW = lake[0][0];
            COL = lake[0][1];
        }
	catch (FileNotFoundException e) {
            System.out.println("Lake not found! Please insert a valid lake file!");
            System.exit(1);
        }
	//=======================================================================

	for (int set = 1; set <= lake[0][3]; set ++){
	    int startRow = lake[ROW + set][0];
	    int startCol = lake[ROW + set][1] - 1;
	    int dig = lake[ROW + set][2];
	    for (;dig>0;dig--){
		findMax(startRow, startCol);
	    }
	}
	
	for (int r = 1; r <= ROW; r ++){
	    for (int c = 0; c < COL; c++){
		if (lake[r][c] >= 22) lake[r][c] = 0;
		else lake[r][c] = 22 - lake[r][c];
	    }
	}
	int total = 0;
	for (int r = 1;r <= ROW; r ++){
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
	    System.out.println(fieldToString());
	    R1 = Integer.parseInt(lastLine.next());
	    C1 = Integer.parseInt(lastLine.next());
	    R2 = Integer.parseInt(lastLine.next());
	    C2 = Integer.parseInt(lastLine.next());
	    field[R1-1][C1-1] =1;
	    placeHolder = new int[N][M];
	    toPlace();
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
	while (T > 0){
	    for (int row = 0; row < N; row ++){
		for (int col = 0; col < M ; col++){
		    //if (field[row][col] == 0) add(row,col);
		    //else if (field[row][col] != -1) field[row][col] = 0;
		    if (field[row][col] != -1) add(row,col);
		    System.out.println(fieldToString());
		}
	    }
	    toField();
	    T--;
	}
	System.out.println(fieldToString());
	return field[R2-1][C2-1];
    }

    private void add( int r, int c){
	placeHolder[r][c] = 0;
	if (r + 1 < N && field[r+1][c]!=-1) placeHolder[r][c] += field[r+1][c];
	if (r - 1 >= 0 && field[r-1][c]!=-1) placeHolder[r][c] += field[r-1][c];
	if (c + 1 < M && field[r][c+1]!=-1) placeHolder[r][c] += field[r][c+1];
	if (c - 1 >- 0 && field[r][c-1]!=-1) placeHolder[r][c] += field[r][c-1];
    }

	    

    private static int[] StringtoInt(String[] str) {
	int[] ans = new int[str.length];
	for (int i = 0; i < str.length; i++) ans[i] = Integer.parseInt(str[i]);
	return ans;
    }

    
    private String fieldToString(){
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
	//        USACO l = new USACO();
	
	//for (int[] i : l.lake) System.out.println(Arrays.toString(i));
	//System.out.println(l.silver(args[0]));
    }
}
