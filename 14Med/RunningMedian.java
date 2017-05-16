public class RunningMedian{

    int median,minSize,maxSize;
    MyHeap min,max;
    boolean hasMedian;

    public RunningMedian(){
	max = new MyHeap();
	min = new MyHeap(false);
	hasMedian = false; 
    }

    public void add(int input){
	if (!hasMedian) {
	    median = input;
	    hasMedian = true;
	}
	else if (min.getSize()==max.getSize()){
	    if (input == 1) System.out.println("DID THIS");
	    //System.out.println("= " + max.getSize() + "median: " + median);
	    if (input < median) max.add(input);
	    else if (input >= median)  min.add(input);
	    System.out.println(max);
	    //else if (input == 1) System.out.println(max);


	    
	    
	}
	else if (max.getSize() > min.getSize()){
	    if (input < median){
		//try doing manually peek and check if its less than input. if not then it becomes median
		max.add(input);
		min.add(median);
		median = max.remove();
	    } else min.add(input);
	}
	else {
	    if (input > median){
		min.add(input);
		max.add(median);
		median = min.remove();
	    } else max.add(input);
	}
    }
    
    
    public double getMedian(){
	if (min.getSize() == max.getSize()) return median;
	else if (min.getSize() > max.getSize()) return avg(min.peek(),median);
	else return avg(max.peek(),median);
    }

    private double avg(int a, int b){
	return (a+b)/2.0;
    }

    public String toString(){
	return max +"\n"+ median + "\n" + min;
    }

    

    public static void main(String[] args){
	
	RunningMedian m = new RunningMedian();
	m.add(8);
	m.add(3);
	m.add(4);

        System.out.println(m+"\n");

	m.add(1);
	System.out.println(m+"\n");
	
	m.add(6);
	System.out.println(m+"\n");
	//System.out.println(m.getMedian());

	m.add(4);
        System.out.println(m+"\n");
        //System.out.println(m.getMedian());
    }
}