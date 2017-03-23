import java.util.*;
public class Quick{

    //==================================================================================================

    public static int quickselect(int []data, int k){
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
	int var = part(data, 0, data.length - 1);
	while (k != var){
	    if (var > k) var = part(data, 0, var);
	    if (var < k) var = part(data, var+1,data.length-1);
	}
	
	return data[k];
    }

    private static int part(int []data, int start, int end){
        Random r = new Random();
        int pivot = r.nextInt(end-start) + start;
        int v = data[pivot];
        int i = start+1;
        swap(data, pivot, start);
        while (i<=end){
            if (data[i]==v) i++;
            else if (data[i]<v){
                swap(data,start,i);
                i++;
                start++;
            }
            else {
                swap(data,end,i);
                end--;
            }
                                                                                                                                                     
        }                                                                                                                                             
	return (start + end)/2;
    }


    //===================================================================================================

    public static void quicksort(int []data){
        partition(data, 0, data.length-1);
    }

    public static void partition(int []data, int start, int end){
	if (end - start > 1){
	    Random r = new Random();
	    int pivot = r.nextInt(end-start) + start;
	    int v = data[pivot];
	    int i = start+1;
	    int origin = start;
	    int finish = end;
	    swap(data, pivot, start);
	    while (i<=end){
		if (data[i]==v) i++;
		else if (data[i]<v){
		    swap(data,start,i);
		    i++;
		    start++;
		}
		else {
		    swap(data,end,i);
		    end--;
		}
	     }
	    partition(data, origin, start);
	    partition(data, end, finish);
	}
    }
    

    private static void swap(int []data, int replacement, int subst){
	int rep = data[replacement];
	data[replacement] = data[subst];
	data[subst] = rep;
    }

    //==================================================================================================

    public static String arr(int [] data){
	String ans = "";
	for (int i=0; i < data.length; i++){
	    ans+= data[i] + ", ";
	}
	return ans;
    }

    //============================================

    public static void main (String [] args){
	/*
	int [] ar = new int[20];
	String s = "";
	Random r = new Random();
	for (int i = 0; i < ar.length; i++){
	    ar[i] = r.nextInt(8);
	    s += ar[i]+",";
	}
	System.out.println("Originals Arr \n" + s + "\n");
	System.out.println(quickselect(ar,8));
	quicksort(ar);
	*/

    }
}
