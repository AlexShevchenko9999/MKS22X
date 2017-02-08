public class Recursion {
    public static String name(){
	return "Shevchenko,Alexander";
    }

    public static double sqrt(double n){
	if (n<0) throw new IllegalArgumentException();
        return isCloseEnough(n,1);
    }   

    public static double isCloseEnough(double n, double guess){
	if (n-(guess * guess) <= (n*.001)&& n-(guess * guess) >= (n*-.001)){
	   String strGuess = Double.toString(guess);
	   if (strGuess.charAt(strGuess.indexOf('.') + 1) == '0')return (int)guess;
	   return guess;

	}
        return isCloseEnough(n,(n/guess + guess)/2);
    }   

    public static void main(String[] arg){
	System.out.println(sqrt(1));
    }
}
