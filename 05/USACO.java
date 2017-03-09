
import java.util.*;
import java.io.*;
public class USACO {
    private int[][] lake;
    private int ROW,COL;


    public void bronze (String filename) {
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
    }

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
    
    public int solveB(){
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

    private static int[] StringtoInt(String[] str) {
	int[] ans = new int[str.length];
	for (int i = 0; i < str.length; i++) ans[i] = Integer.parseInt(str[i]);
	return ans;
    }

    
	

    public static void main(String[] args) {
        USACO l = new USACO();
	l.bronze(args[0]);
	//for (int[] i : l.lake) System.out.println(Arrays.toString(i));
	System.out.println(l.solveB());
    }
}
