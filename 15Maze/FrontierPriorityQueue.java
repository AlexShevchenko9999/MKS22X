import java.util.*;
public class FrontierPriorityQueue implements Frontier{

    private int size;
    private ArrayList<Location> heap;
    private int mix=1;

    public FrontierPriorityQueue(){
        size = 0;
        heap = new ArrayList<Location>();
        heap.add(null);
    }

    public FrontierPriorityQueue(boolean boo){
        this();
        if (!boo) mix = -1;
    }

    public void add(Location s){
        heap.add(s);
        size++;
        pushUp(size);
    }

    private void pushUp(int index){
        if (index > 1){
            if (mix*(heap.get(index).compareTo(heap.get(index/2))) > 0){
                Location repl = heap.get(index);
                heap.set(index,heap.get(index/2));
                heap.set(index/2,repl);
                pushUp(index/2);
            }
        }
    }

    public Location remove(){
        Location repl = heap.get(1);
        heap.set(1,heap.remove(size));
        size--;
        pushDown(1);
        return repl;
    }

    private void pushDown(int index){
        if (index*2 <= size){
            int big = getMax(index);
            if (mix*(heap.get(index).compareTo(heap.get(big))) < 0){
                swap(index,big);
                pushDown(big);
            }
        }
    }

    private int getMax(int index){
        if (index*2 + 1 > size || heap.get(index*2).compareTo(heap.get(index*2+1)) > 0) return index*2;
        else return index*2+1;
    }


    private void swap(int first,int second){
        Location repl = heap.get(first);
        heap.set(first,heap.get(second));
        heap.set(second,repl);
    }

    public Location peek(){
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

    public Location next(){
	return heap.get(1);
    }

}