import java.io.*;
import java.util.*;

public class PrefixEvaluationAndConversion{

public static int solve(int v1,int v2,char ch){
     if(ch=='+'){
         return v1+v2;
     }
     else if(ch=='-'){
         return v1-v2;
     }
     else if(ch=='/'){
         return v1/v2;
     }
     else{
         return v1*v2;
     }
}

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> evaluated = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> postfix = new Stack<>();

    for(int i=exp.length()-1;i>=0;i--){
        char ch = exp.charAt(i);

        if(Character.isDigit(ch)){
            evaluated.push(ch-'0');
            infix.push(ch+"");
            postfix.push(ch+"");
        }
        else if(ch=='+' || ch=='-' || ch=='/' || ch=='*'){
            int v1=evaluated.pop();
            int v2=evaluated.pop();
            int val = solve(v1,v2,ch);
            evaluated.push(val);

            String inv1 = infix.pop();
            String inv2 = infix.pop();
            String inval = "(" + inv1 + ch + inv2 +")" ;
            infix.push(inval);

            String postv1 = postfix.pop();
            String postv2 = postfix.pop();
            String postval =  postv1 + postv2 + ch ;
            postfix.push(postval);

        }
    }
    System.out.println(evaluated.peek());
    System.out.println(infix.peek());
    System.out.println(postfix.peek());
 }
}