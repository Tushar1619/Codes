import java.io.*;
import java.util.*;

public class InfixEvaluation{
  
public static int solve(int v1,int v2,char ch){
    if(ch=='+'){
        return v1+v2;
    }else if(ch=='-'){
        return v1-v2;
    }else if(ch=='*'){
        return v1*v2;
    }else{
        return v1/v2;
    }
}
public static int precedence(char ch){
    if(ch=='+'){
        return 1;
    }else if(ch=='-'){
        return 1;
    }else if(ch=='*'){
        return 2;
    }else{
        return 2;
    }
}
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> oprnds = new Stack<>();//integer
    Stack<Character> oprtrs = new Stack<>();//sign

    for(int i=0;i<exp.length();i++){
        char ch=exp.charAt(i);

        if(ch=='('){
            oprtrs.push(ch);
        }
        else if(Character.isDigit(ch)){
            oprnds.push(ch-'0');
        }
        else if(ch==')'){
            while(oprtrs.peek()!='('){
                char oprtr=oprtrs.pop();
                int v2=oprnds.pop();
                int v1=oprnds.pop();

                int val=solve(v1,v2,oprtr);
                oprnds.push(val);
            }
            oprtrs.pop();
        }
        else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
             while(oprtrs.size()!=0 && oprtrs.peek()!='(' && precedence(ch)<=precedence(oprtrs.peek())){
                char oprtr=oprtrs.pop();
                int v2=oprnds.pop();
                int v1=oprnds.pop();

                int val=solve(v1,v2,oprtr);
                oprnds.push(val);
            }
            oprtrs.push(ch);
        }
    }
    while(oprtrs.size()!=0){
           char oprtr=oprtrs.pop();
                int v2=oprnds.pop();
                int v1=oprnds.pop();

                int val=solve(v1,v2,oprtr);
                oprnds.push(val);
    }
    System.out.println(oprnds.peek());
 }
}