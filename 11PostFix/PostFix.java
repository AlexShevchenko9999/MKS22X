import java.util.*;
public class PostFix{
    
    public static double eval(String s){
	String [] tokens = s.split(" ");
	Stack<Double> values = new Stack<Double>();
	for (String token:tokens){
	    if (isOp(token)) values.push(apply(token,values.pop(),values.pop()));
	    else values.push(Double.parseDouble(token));
	}
	return values.pop();
    }
    
    private static double apply(String op, Double second, Double first){
	if (op.equals("*")) return first * second;
	else if (op.equals("/")) return first / second;
	else if(op.equals("+")) return first + second;
	else if(op.equals("-")) return first - second;
	else if(op.equals("%")) return first % second;
	else throw new IllegalArgumentException();
    }

    private static boolean isOp(String op){
	if (op.equals("*") || 
	    op.equals("/") ||
	    op.equals("+") ||
	    op.equals("-") ||
	    op.equals("%")  ) return true;
	else return false;
    }

}