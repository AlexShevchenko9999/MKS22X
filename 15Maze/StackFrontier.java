import java.util.*;
public class StackFrontier implements Frontier{

    private Stack<Location> st = new Stack<Location>();

    public void add(Location s){
	st.push(s);
    }

    public Location next(){
	return st.peek();
    }
    
}