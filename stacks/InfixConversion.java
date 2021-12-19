import java.io.*;
import java.util.*;

public class InfixConversion{
  
    public static int precedence(char ch){
        if(ch=='+'){
            return 1;
        }else if(ch=='-'){
            return 1;
        }else if(ch=='/'){
            return 2;
        }else{
            return 2;
        }
    }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<String> post = new Stack<>();
    Stack<String> pre = new Stack<>();
    Stack<Character> ops=new Stack<>();

    for(int i=0;i<exp.length();i++){
        char ch=exp.charAt(i);
        if(ch=='('){
            ops.push(ch);
        }
        else if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='1' && ch<='9')){
            post.push(ch+"");
            pre.push(ch+"");
        }
        else if(ch==')'){
            while(ops.peek()!='('){
                char op=ops.pop();

                String post_val2=post.pop();
                String post_val1=post.pop();
                String postVal=post_val1+post_val2+op;
                post.push(postVal);

                String pre_val2=pre.pop();
                String pre_val1=pre.pop();
                String preVal=pre_val1+pre_val2+op;
                pre.push(preVal);
            }
            ops.pop();
        }
        else if(ch=='+' || ch=='-' || ch=='/' || ch=='*'){
            while(ops.size()>0 && ops.peek()!='(' && precedence(ch)<=precedence(ops.peek())){
                char op=ops.pop();
                
                String pre_val2=pre.pop();
                String pre_val1=pre.pop();
                String preVal=pre_val1+pre_val2+op;
                pre.push(preVal);
                
                String post_val2=post.pop();
                String post_val1=post.pop();
                String postVal=post_val1+post_val2+op;
                post.push(postVal);

                
            }
            ops.push(ch);
        }
    }
    while(ops.size()>0){
        char op=ops.pop();

        String post_val2=post.pop();
        String post_val1=post.pop();
        String postVal=post_val1+post_val2+op;
        post.push(postVal);

        String pre_val2=pre.pop();
        String pre_val1=pre.pop();
        String preVal=pre_val1+pre_val2+op;
        pre.push(preVal);
    }
    System.out.println(post.peek());
    System.out.println(pre.peek());
 }
}