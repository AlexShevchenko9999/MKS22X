import java.util.*;
public class StackCalc{
    
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
	else if(op.equals("/")) return first / second;
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

    public static void main(String [] args){
	System.out.println(eval("10 2 +"));//12.0
	System.out.println(eval("10 2 -"));//8.0
	System.out.println(eval("10 2.0 +"));//12.0
	System.out.println(eval("11 3 - 4 + 2.5 *"));//30.0
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));//839.0
	System.out.println(eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
    }

}