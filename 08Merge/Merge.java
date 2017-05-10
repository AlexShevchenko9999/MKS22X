import java.util.Arrays;
import java.util.Random;
public class Merge{


    public static void mergesort(int []a){
	if (a.length == 1) return;
	int [] left = Arrays.copyOfRange(a, 0, a.length/2);
	int [] right= Arrays.copyOfRange(a,a.length/2, a.length);
	//System.out.println("Left: " + arr(left));
	//System.out.println("Right: "+arr(right));
	
	mergesort(right);
	mergesort(left);
	merge(left, right, a);
    }
    
    private static void merge(int []left, int[]right, int []a){
	clear(a);
	//System.out.println("Left: " + arr(left));
        //System.out.println("Right: "+arr(right));
	int aIndex = 0;
	int rightIndex = 0;
	int leftIndex = 0;
	while (leftIndex < left.length && rightIndex < right.length){
	    if (left[leftIndex]<right[rightIndex]){
		a[aIndex] = left[leftIndex];
		leftIndex++;
	    }
	    else {
		a[aIndex] = right[rightIndex];
		rightIndex++;
	    }
	    aIndex++;
	    //System.out.println("After " + aIndex + "run  "  + arr(a));
	}
	//System.out.println("After first run: " + arr(a));
	//System.out.println("Right Index: " + rightIndex );
	while (leftIndex < left.length){
	    a[aIndex] = left[leftIndex];
	    aIndex++;
	    leftIndex++;
	}
	while (rightIndex <right.length){
            a[aIndex] = right[rightIndex];
            aIndex++;
            rightIndex++;
        }

	//System.out.println("mergeH: " + arr(a));
    }

    private static void clear(int [] a){
	for (int i = 0; i < a.length; i ++) a[i] = 0;
    }

    public static String arr(int [] data){
        String ans = "";
        for (int i=0; i < data.length; i++){
            ans+= data[i] + ", ";
        }
        return ans;
    }

    public static void main(String []args){
	int [] ar = new int[4567];
        String s = "";
        Random r = new Random();
        for (int i = 0; i < ar.length; i++){
            ar[i] = r.nextInt(10);
            s += ar[i]+",";
        }
	System.out.println("Originals Arr \n" + s + "\n");
	mergesort(ar);
	System.out.println(arr(ar));
    }

}