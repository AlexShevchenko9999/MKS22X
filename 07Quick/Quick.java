import java.util.*;
public class Quick{

    

    public static int part ( int [] data, int start, int end){
	//-Choose a random element to be a pivot, and partition the array around it. 
	//-Only partition the elements from start to end inclusive.
	//-When done returns the index of the final position of the pivot element.      
	//    (Should be from start to end inclusive)
	Random rand = new Random();
	int pivot = rand.nextInt(end-start) + start;
	System.out.println("Pivot:" + pivot);
	

	for (int i = start; i <= end; i++){
	    
	    if (i < pivot && data[i] > data[pivot]){
		int placeHolder = data[i];
		data[i] = data[pivot];
		data[pivot] = placeHolder;
		pivot = i;
		i = 0;
	    }
	    else if (i > pivot && data[i] < data[pivot]){
		int placeHolder= data[i];
		data[i] = data[pivot];
		data[pivot] = placeHolder;
		pivot = i;
		i = 0;
	    }
	}
	
	/*
	String s = "";
	
	for (int i=0; i < data.length; i ++) s += data[i] + ", ";
	System.out.println("new: " + s);
	*/
	return pivot;
    }
    


    public static int quickselect(int []data, int k){
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
	int var = part(data, 0, data.length - 1);
	while (k != var){
	    System.out.println("Var:" + var);
	    System.out.println(arr(data));
	    if (var > k) var = part(data, 0, var);
	    if (var < k) var = part(data, var+1,data.length-1);
	}
	return data[k];
    }

    public static String arr(int [] data){
	String ans = "";
	for (int i=0; i < data.length; i++){
	    ans+= data[i] + ", ";
	}
	return ans;
    }





    public static void main (String [] args){
	int [] ar = new int[10];
	String s = "";
	Random r = new Random();
	for (int i = 0; i < ar.length; i++){
	    ar[i] = r.nextInt(30);
	    s += ar[i]+",";
	}

	
	System.out.println("Originals Arr \n" + s + "\n");
	System.out.println(quickselect(ar,4));
	//String d = "";
	//for (int i = 0; i < ar.length; i++) d += ar[i]+",";
	//System.out.println(d);



    }
}
