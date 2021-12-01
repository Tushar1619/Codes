import java.io.*;
import java.util.*;

public class NextGreatElementToTheRight {
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   // solve

   // pop  ans  push 

   int n=arr.length;
     Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
            st.push(arr[n-1]);
            ans[n-1]=-1;

        
        //pop
        for(int i=n-2;i>=0;i--){
          while(st.size()!=0 && st.peek()<=arr[i]){
            st.pop();
          }

          //ans
          if(st.size()==0){
              ans[i]=-1;
          }else{
              ans[i]=st.peek();
          }

          //push
          st.push(arr[i]);
        }
   return ans;
   
 }

}