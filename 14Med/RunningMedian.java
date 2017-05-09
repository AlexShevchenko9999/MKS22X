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
	    if (input < median) max.add(input);
	    else min.add(input);
	}
	else if (max.getSize() > min.getSize()){
	    if (input < median){

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
    
    
    public double getMed(){
	if (min.getSize() == max.getSize()) return median;
	else if (min.getSize() > max.getSize()) return avg(min.peek(),median);
	else return avg(max.peek(),median);
    }

    private double avg(int a, int b){
	return (a+b)/2.0;
    }

    public String toString(){
	return max.toString() +"\n"+ median + "\n" + min.toString();
    }

    public static void main(String[] args){
	
	RunningMedian m = new RunningMedian();
	m.add(8);
	m.add(3);
	m.add(4);
	System.out.println(m.getMed());
        System.out.println(m+"\n");

	m.add(1);
	System.out.println(m.getMed());
	System.out.println(m+"\n");
	
	m.add(6);
	System.out.println(m+"\n");
	System.out.println(m.getMed());

    }
}