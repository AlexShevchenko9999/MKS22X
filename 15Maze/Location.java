public class Location implements Comparable<Location>{

    private int row,col;
    private int distToGoal;
    private int distToStart;
    private Location previous;
    private boolean aStar;

    public Location(int r, int c, Location previous , int distToStart, int distToGoal, boolean aStar){
	row = r;
	col = c;
	previous = this.previous;
	distToStart = this.distToStart;
	distToGoal = this.distToGoal;
	aStar = this.aStar;
    }

    public int getDistToGoal(){
	return distToGoal;
    }

    public int getDistToStart(){
	return distToStart;
    }


    //compares locations
    //returns positive if first one is farther 
    public int compareTo(Location L){
	if (aStar){
	    Integer one = new Integer(distToGoal+distToStart);
	    Integer two = new Integer(L.getDistToGoal()+L.getDistToStart());
	    return one.compareTo(two);
	} else {
	    Integer one = new Integer(distToStart);
	    Integer two = new Integer(L.getDistToStart());
	    return one.compareTo(two);
	}
    }

    public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }

    public Location getPrev(){
	return previous;
    }


    
	
}