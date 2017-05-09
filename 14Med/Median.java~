public class Median{

    int median,minSize,maxSize;
    intHeap min,max;

    public Median(){
	max = new intHeap();
	min = new intHeap(false);
	median = null;
    }

    public void add(int input){
	if (median == null){
	    median = input;
	}
	else {
	    if (input < median){
		min.add(input);
	    }
	    else {
		max.add(input);
	    }
	}
    }
    
    public int getMed(){
	if (min.getSize() == max.getSize()) return median;
	else if (min.getSize() > max.getSize()) return min.peek();
	else return max.peek();
    }


}