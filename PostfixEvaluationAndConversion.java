import java.io.*;
import java.util.*;

public class PostfixEvaluationAndConversion{
  
public static int solve(int v1, int v2 , char ch){
    if(ch=='+'){
        return v1+v2;
    }
    else if(ch=='-'){
        return v1-v2;
    }
    else if(ch=='*'){
        return v1*v2;
    }
    else {
        return v1/v2;
    }
}
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> evaluated = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();

    for(int i=0;i<exp.length();i++){
        char ch = exp.charAt(i);

        if(Character.isDigit(ch)){
            evaluated.push(ch-'0');
            infix.push(ch+"");
            prefix.push(ch+"");
        }
        else if(ch=='+' || ch=='-' || ch=='/' || ch=='*'){
            int v2=evaluated.pop();
            int v1=evaluated.pop();
            int val=solve(v1,v2,ch);
            evaluated.push(val);

            String in2 = infix.pop();
            String in1 = infix.pop();
            String inval = "(" + in1 + ch + in2 + ")" ;
            infix.push(inval);
            
            String pre2 = prefix.pop();
            String pre1 = prefix.pop();
            String preval = ch + pre1 + pre2 ;
            prefix.push(preval);
        }
    }
    System.out.println(evaluated.peek());
    System.out.println(infix.peek());
    System.out.println(prefix.peek());
 }
}