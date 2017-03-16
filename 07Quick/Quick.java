import java.util.*;
public class Quick{

    public static int part ( int [] data, int start, int end){
	//-Choose a random element to be a pivot, and partition the array around it. 
	//-Only partition the elements from start to end inclusive.
	//-When done returns the index of the final position of the pivot element.      
	//    (Should be from start to end inclusive)
	Random rand = new Random();
	int pivot = rand.nextInt(end-start+1) + start;
	System.out.println(pivot);
	for (int i = start; i < end; i++){
	    if (i < pivot && data[i] > data[pivot]){
		int placeHolder = data[i];
		data[i] = data[pivot];
		data[pivot] = placeHolder;
		pivot = i;
	    }
	    if (i > pivot && data[i] < data[pivot]){
		int placeHolder= data[i];
		data[i] = data[pivot];
		data[pivot] = placeHolder;
		pivot =i;
	    }
	}
	return pivot;
    }


    public static void quickselect(int []data, int k){
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
	
    }

    public static void main (String [] args){
	int [] ar = new int[10];
	String s = "";
	Random r = new Random();
	for (int i = 0; i < ar.length; i++){
	    ar[i] = r.nextInt(30);
	    s += ar[i]+",";
	}
	System.out.println(s);
	System.out.println(part(ar, 0, 9));
	String d = "";
	for (int i = 0; i < ar.length; i++) d += ar[i]+",";
	System.out.println(d);
    }
}
