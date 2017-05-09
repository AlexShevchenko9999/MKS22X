public class Median{

    int median,minSize,maxSize;
    intHeap min,max;
    boolean hasMedian;

    public Median(){
	max = new intHeap();
	min = new intHeap(false);
	hasMedian = false; 
    }

    public void add(int input){
	if (!hasMedian) {
	    median = input;
	    hasMedian = true;
	}
	else if (input < median) min.add(input);
	else max.add(input);
    }
    
    
    public int getMed(){
	if (min.getSize() == max.getSize()) return median;
	else if (min.getSize() > max.getSize()) return min.peek();
	else return max.peek();
    }

    public static void main(String[] args){
	
	Median m = new Median();
	m.add(654);
	m.add(3);
	m.add(5);
	System.out.println(m.getMed());

    }


}