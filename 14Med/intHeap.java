import java.util.*;
public class intHeap{
    private int size;
    private ArrayList<Integer> heap;
    private int mix=1;

    public intHeap(){
        size = 0;
        heap = new ArrayList<Integer>();
        heap.add(null);
    }

    public intHeap(boolean boo){
        this();
        if (!boo) mix = -1;
    }

    public void add(int s){
        heap.add(s);
        size++;
        pushUp(size);
    }

    private void pushUp(int index){
        if (index > 1){
            if (mix*(heap.get(index).compareTo(heap.get(index/2))) > 0){
                //System.out.println(heap.get(index).compareTo(heap.get(index/2)));                                                                                                  
                int repl = heap.get(index);
                heap.set(index,heap.get(index/2));
                heap.set(index/2,repl);
                pushUp(index/2);
            }
        }
    }

    public int remove(){
        int repl = heap.get(1);
        heap.set(1,heap.get(size));
        size--;
        pushDown(1);
        return repl;
    }

    private void pushDown(int index){
        //System.out.println(Math.pow((int)(Math.log(size)/Math.log(2)),2));                                                                                                         
        if (index < Math.pow((int)(Math.log(size)/Math.log(2)),2)){
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
        int repl = heap.get(first);
        heap.set(first,heap.get(second));
        heap.set(second,repl);
    }

    public int peek(){
        return heap.get(1);
    }


    public String toString(){
        String ans="";
        for (int i = 1; i <= size; i++){
            ans += heap.get(i) + " ";
        }
        return ans;
    }

    public int getSize(){
	return size;
    }

}