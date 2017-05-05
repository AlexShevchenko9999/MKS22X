import java.util.*;
public class MyHeap{
    private int size;
    private ArrayList<String> heap; 
    private int mix=-1;

    public MyHeap(){
	size = 0;
	heap = new ArrayList<String>();
	heap.add(null);
    }

    public MyHeap(boolean boo){
	this();
	if (boo) mix = 1;
    }

    public void add(String s){
	heap.add(s);
	size++;
	pushUp(size);
    }

    private void pushUp(int index){
	if (index > 1){
	    if (mix*(heap.get(index).compareTo(heap.get(index/2))) < 0){
		//System.out.println(heap.get(index).compareTo(heap.get(index/2)));
		String repl = heap.get(index);
		heap.set(index,heap.get(index/2));
		heap.set(index/2,repl);
		pushUp(index/2);
	    } 
	}
    }

    public String remove(){
	String repl = heap.get(1);
	heap.set(1,heap.get(size));

	return repl;
    }

    private void pushDown(int index){
	if (index < (int)Math.pow(Math.log(size)/Math.log(2),2)){
	    int big = getMax(index);
	    if (mix*(heap.get(index).compareTo(heap.get(big))) < 0){
		swap(index,big);
		pushDown(big);
	    }
	}
    }

    private int getMax(int index){
	if (heap.get(index*2).compareTo(heap.get(index*2+1)) > 0) return index*2;
	else return index*2+1;
    }
   

    private void swap(int first,int second){
	String repl = heap.get(first);
	heap.set(first,heap.get(second));
	heap.set(second,repl);
    }

    public String peek(){
	return heap.get(1);
    }


    public String toString(){
	String ans="";
	for (int i = 1; i <= size; i++){
	    ans += heap.get(i) + " ";
	}
	return ans;
    }

    public static void main(String [] args){
	MyHeap h = new MyHeap();
	h.add("f");
	h.add("h");
	h.add("z");
	h.add("a");
	h.add("b");
	h.add("y");
	h.add("A");
	h.add("c");
	h.remove();
	System.out.println(h.remove());
	System.out.println(h);
    }
}